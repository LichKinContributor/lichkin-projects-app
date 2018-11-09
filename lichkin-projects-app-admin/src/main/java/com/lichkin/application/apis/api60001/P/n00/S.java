package com.lichkin.application.apis.api60001.P.n00;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.application.utils.LKDictUtils4App;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service("SysAppVersionP00Service")
public class S extends LKApiBusGetPageService<I, O, SysAppVersionEntity> {

	@Override
	protected Page<O> beforeQuery(I sin, String locale, String compId, String loginId) {
		if (StringUtils.isBlank(sin.getAppKey())) {
			return emptyPage();
		}
		return null;
	}


	@Override
	protected void initSQL(I sin, String locale, String compId, String loginId, QuerySQL sql) {
		// 主表
		sql.select(SysAppVersionR.id);
		sql.select(SysAppVersionR.insertTime);
		sql.select(SysAppVersionR.versionX);
		sql.select(SysAppVersionR.versionY);
		sql.select(SysAppVersionR.versionZ);
		sql.select(SysAppVersionR.forceUpdate);
		sql.select(SysAppVersionR.tip);
		sql.select(SysAppVersionR.url);
		sql.select(SysAppVersionR.publishTime);

		// 关联表

		// 字典表
		int i = 0;
		LKDictUtils4App.appVersionUsingStatus(sql, SysAppVersionR.usingStatus, i++);
		LKDictUtils4App.appKey(sql, compId, SysAppVersionR.appKey, i++);
		LKDictUtils.clientType(sql, SysAppVersionR.clientType, i++);

		// 筛选条件（必填项）
		// 在用状态
		LKUsingStatusEnum usingStatus = sin.getUsingStatus();
		if (usingStatus == null) {
			if (LKFrameworkStatics.LichKin.equals(compId)) {
				sql.neq(SysAppVersionR.usingStatus, LKUsingStatusEnum.DEPRECATED);
			} else {
				sql.eq(SysAppVersionR.usingStatus, LKUsingStatusEnum.USING);
			}
		} else {
			sql.eq(SysAppVersionR.usingStatus, usingStatus);
		}

		// 筛选条件（业务项）
		String appKey = sin.getAppKey();
		if (StringUtils.isNotBlank(appKey)) {
			sql.eq(SysAppVersionR.appKey, appKey);
		}

		LKClientTypeEnum clientType = sin.getClientType();
		if (clientType != null) {
			sql.eq(SysAppVersionR.clientType, clientType);
		}

		// 排序条件
		sql.addOrders(new Order(SysAppVersionR.id, false));
	}

}
