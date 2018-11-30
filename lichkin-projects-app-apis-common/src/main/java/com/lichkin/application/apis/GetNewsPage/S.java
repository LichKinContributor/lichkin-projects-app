package com.lichkin.application.apis.GetNewsPage;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lichkin.defines.AppStatics;
import com.lichkin.framework.beans.impl.Datas;
import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppNewsR;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.db.beans.like;
import com.lichkin.framework.db.enums.LikeType;
import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.services.LKApiService;
import com.lichkin.springframework.services.LKApiServiceImpl;
import com.lichkin.springframework.utils.LKPageUtils;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiServiceImpl<I, Page<O>> implements LKApiService<I, Page<O>> {

	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl}")
	private String filesServerRootUrl;

	/** 接口服务器URL根路径 */
	@Value("${com.lichkin.apis.server.rootUrl}")
	private String apisServerRootUrl;


	@Override
	public Page<O> handle(I sin, ApiKeyValues<I> params) throws LKException {
		return LKPageUtils.convert(getPageEntity(sin, params), source -> {
			O target = new O(apisServerRootUrl + AppStatics.PAGE_URL_APP_NEWS + LKFrameworkStatics.WEB_MAPPING_PAGES + "?id=" + source.getId(), source.getTitle(), source.getBrief());

			List<String> imageList = new ArrayList<>();
			target.setImageUrls(imageList);

			if (StringUtils.isBlank(source.getImageUrl1())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl1());

			if (StringUtils.isBlank(source.getImageUrl2())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl2());

			if (StringUtils.isBlank(source.getImageUrl3())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl3());

			if (StringUtils.isBlank(source.getImageUrl4())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl4());

			if (StringUtils.isBlank(source.getImageUrl5())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl5());

			if (StringUtils.isBlank(source.getImageUrl6())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl6());

			if (StringUtils.isBlank(source.getImageUrl7())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl7());

			if (StringUtils.isBlank(source.getImageUrl8())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl8());

			if (StringUtils.isBlank(source.getImageUrl9())) {
				return target;
			}
			imageList.add(filesServerRootUrl + source.getImageUrl9());

			return target;
		});
	}


	private Page<SysAppNewsEntity> getPageEntity(I sin, ApiKeyValues<I> params) {
		Datas datas = sin.getDatas();

		QuerySQL sql = new QuerySQL(false, SysAppNewsEntity.class);

		// 国际化
//		addConditionId(sql, SysAppNewsR.id, params.getId());
		addConditionLocale(sql, SysAppNewsR.locale, params.getLocale());
		addConditionCompId(true, sql, SysAppNewsR.compId, params.getCompId(), params.getBusCompId());
		addConditionUsingStatus(true, params.getCompId(), sql, SysAppNewsR.usingStatus, params.getUsingStatus(), LKUsingStatusEnum.USING);

		sql.eq(SysAppNewsR.usingStatus, LKUsingStatusEnum.USING);
		sql.eq(SysAppNewsR.compId, params.getCompId());
		sql.eq(SysAppNewsR.appKey, datas.getAppKey());
		sql.eq(SysAppNewsR.clientType, datas.getClientType());

		sql.eq(SysAppNewsR.categoryCode, StringUtils.trimToEmpty(sin.getCategoryCode()));

		sql.where(

				new Condition(true,

						new Condition(true, new like(SysAppNewsR.versions, LikeType.ALL, String.format("%s%s.%s.%s%s", LKFrameworkStatics.SPLITOR, datas.getVersionX(), datas.getVersionY(), datas.getVersionZ(), LKFrameworkStatics.SPLITOR))),

						new Condition(false, new eq(SysAppNewsR.versions, ""))

				)

		);

		sql.addOrders(new Order(SysAppNewsR.orderId), new Order(SysAppNewsR.id));

		sql.setPage(sin);

		return dao.getPage(sql, SysAppNewsEntity.class);
	}

}
