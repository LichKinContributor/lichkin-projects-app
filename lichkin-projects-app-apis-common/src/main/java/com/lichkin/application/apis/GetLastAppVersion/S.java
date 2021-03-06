package com.lichkin.application.apis.GetLastAppVersion;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.lichkin.framework.beans.impl.Datas;
import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.db.beans.gt;
import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.framework.utils.LKBeanUtils;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppApiRequestLogEntity;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiService;
import com.lichkin.springframework.services.LKApiServiceImpl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiServiceImpl<I, O> implements LKApiService<I, O> {

	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		app_no_version_found(40000),

		version_inexist(49998),

		app_version_temporarily_stop_using(49999),

		;

		private final Integer code;

	}


	@Override
	@Transactional
	public O handle(I sin, ApiKeyValues<I> params) throws LKException {
		// 取统一请求参数
		Datas datas = sin.getDatas();

		// 存储日志
		SysAppApiRequestLogEntity log = LKBeanUtils.newInstance(true, datas, SysAppApiRequestLogEntity.class);
		LKBeanUtils.copyProperties(sin, log, "id");
		log.setLocale(params.getLocale());
		log.setAppKey(datas.getAppKey());
		log.setLoginId(params.getLoginId());
		dao.persistOne(log);

		// 查询发送当前请求的版本信息
		SysAppVersionEntity entity = getCurrentAppVersion(datas);

		// 验证当前版本信息
		if (entity == null) {
			throw new LKException(ErrorCodes.version_inexist);
		}

		// 验证是否挂起
		if (Boolean.TRUE.equals(entity.getHangUp())) {
			throw new LKException(ErrorCodes.app_version_temporarily_stop_using);
		}

		// 查询所有版本信息
		List<O> list = getLastAppVersionList(datas);

		// 验证所有版本信息
		if (CollectionUtils.isEmpty(list)) {
			throw new LKException(ErrorCodes.app_no_version_found);
		}

		// 获取最新版本信息
		O out = list.get(0);
		out.setForceUpdate(entity.getForceUpdate());// 当前版本是否需要强制更新
		tipIf: if (StringUtils.isNotBlank(out.getTip())) {
			String[] tips = out.getTip().split(LKFrameworkStatics.SPLITOR_FIELDS);
			String locale = params.getLocale();
			for (String tip : tips) {
				String[] localeTips = tip.split(LKFrameworkStatics.SPLITOR);
				if (localeTips.length != 2) {
					continue;
				}
				if (localeTips[0].equals(locale)) {
					out.setTip(localeTips[1]);
					break tipIf;
				}
			}
			out.setTip("Welcome to use this app.");
		}
		return out;
	}


	/**
	 * 获取当前版本
	 * @param datas 入参
	 * @return 当前版本
	 */
	private SysAppVersionEntity getCurrentAppVersion(Datas datas) {
		QuerySQL sql = new QuerySQL(false, SysAppVersionEntity.class);

		sql.eq(SysAppVersionR.usingStatus, LKUsingStatusEnum.USING);
		sql.eq(SysAppVersionR.appKey, datas.getAppKey());
		sql.eq(SysAppVersionR.clientType, datas.getClientType());
		sql.eq(SysAppVersionR.versionX, datas.getVersionX());
		sql.eq(SysAppVersionR.versionY, datas.getVersionY());
		sql.eq(SysAppVersionR.versionZ, datas.getVersionZ());

		return dao.getOne(sql, SysAppVersionEntity.class);
	}


	/**
	 * 获取所有比当前版本新的版本
	 * @param datas 入参
	 * @return 所有比当前版本新的版本
	 */
	private List<O> getLastAppVersionList(Datas datas) {
		QuerySQL sql = new QuerySQL(SysAppVersionEntity.class);

		sql.select(SysAppVersionR.versionX);
		sql.select(SysAppVersionR.versionY);
		sql.select(SysAppVersionR.versionZ);
		sql.select(SysAppVersionR.tip);
		sql.select(SysAppVersionR.url);

		sql.eq(SysAppVersionR.usingStatus, LKUsingStatusEnum.USING);
		sql.eq(SysAppVersionR.appKey, datas.getAppKey());
		sql.eq(SysAppVersionR.clientType, datas.getClientType());
		sql.where(

				new Condition(true,

						new Condition(null, new gt(SysAppVersionR.versionX, datas.getVersionX())),

						new Condition(false,

								new Condition(null, new eq(SysAppVersionR.versionX, datas.getVersionX())),

								new Condition(true,

										new Condition(null, new gt(SysAppVersionR.versionY, datas.getVersionY())),

										new Condition(false,

												new Condition(null, new eq(SysAppVersionR.versionY, datas.getVersionY())),

												new Condition(true, new gt(SysAppVersionR.versionZ, datas.getVersionZ()))

										)

								)

						)

				)

		);

		sql.addOrders(new Order(SysAppVersionR.versionX, false), new Order(SysAppVersionR.versionY, false), new Order(SysAppVersionR.versionZ, false));

		return dao.getList(sql, O.class);
	}

}
