package com.lichkin.application.apis.api60003.P.n00;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.application.utils.LKDictUtils4App;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppNewsR;
import com.lichkin.framework.db.enums.LikeType;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service("SysAppNewsP00Service")
public class S extends LKApiBusGetPageService<I, O, SysAppNewsEntity> {

	@Override
	protected Page<O> beforeQuery(I sin, ApiKeyValues<I> params) {
		if (StringUtils.isBlank(sin.getAppKey())) {
			return emptyPage();
		}
		return null;
	}


	@Override
	protected void initSQL(I sin, ApiKeyValues<I> params, QuerySQL sql) {
		// 主表
		sql.select(SysAppNewsR.id);
		sql.select(SysAppNewsR.insertTime);
		sql.select(SysAppNewsR.locale);
		sql.select(SysAppNewsR.versions);
		sql.select(SysAppNewsR.title);
		sql.select(SysAppNewsR.keywords);
		sql.select(SysAppNewsR.author);
		sql.select(SysAppNewsR.linkUrl);
		sql.select(SysAppNewsR.orderId);
		sql.select(SysAppNewsR.publishTime);

		// 关联表

		// 字典表
		int i = 0;
		LKDictUtils4App.newsUsingStatus(sql, SysAppNewsR.usingStatus, i++);
		LKDictUtils4App.appKey(sql, params.getCompId(), SysAppNewsR.appKey, i++);
		LKDictUtils.clientType(sql, SysAppNewsR.clientType, i++);
		LKDictUtils4App.newsCategory(sql, params.getCompId(), SysAppNewsR.categoryCode, i++);
		LKDictUtils4App.newsTemplate(sql, SysAppNewsR.templateCode, i++);

		// 筛选条件（必填项）
//		addConditionId(sql, SysAppNewsR.id, params.getId());
		addConditionLocale(sql, SysAppNewsR.locale, params.getLocale());
		addConditionCompId(true, sql, SysAppNewsR.compId, params.getCompId(), params.getBusCompId());
		addConditionUsingStatus(true, params.getCompId(), sql, SysAppNewsR.usingStatus, params.getUsingStatus(), LKUsingStatusEnum.STAND_BY, LKUsingStatusEnum.USING);

		// 筛选条件（业务项）
		String appKey = sin.getAppKey();
		if (StringUtils.isNotBlank(appKey)) {
			sql.eq(SysAppNewsR.appKey, appKey);
		}

		LKClientTypeEnum clientType = sin.getClientType();
		if (clientType != null) {
			sql.eq(SysAppNewsR.clientType, clientType);
		}

		String categoryCode = sin.getCategoryCode();
		if (StringUtils.isNotBlank(categoryCode)) {
			sql.eq(SysAppNewsR.categoryCode, categoryCode);
		}

		String templateCode = sin.getTemplateCode();
		if (StringUtils.isNotBlank(templateCode)) {
			sql.eq(SysAppNewsR.templateCode, templateCode);
		}

		String title = sin.getTitle();
		if (StringUtils.isNotBlank(title)) {
			sql.like(SysAppNewsR.title, LikeType.ALL, title);
		}

		String keywords = sin.getKeywords();
		if (StringUtils.isNotBlank(keywords)) {
			sql.like(SysAppNewsR.keywords, LikeType.ALL, keywords);
		}

		String author = sin.getAuthor();
		if (StringUtils.isNotBlank(author)) {
			sql.like(SysAppNewsR.author, LikeType.ALL, author);
		}

		// 排序条件
		sql.addOrders(new Order(SysAppNewsR.orderId), new Order(SysAppNewsR.id, false));
	}

}
