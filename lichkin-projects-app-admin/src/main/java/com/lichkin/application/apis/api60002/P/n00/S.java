package com.lichkin.application.apis.api60002.P.n00;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.application.utils.LKDictUtils4App;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppBannerR;
import com.lichkin.framework.db.enums.LikeType;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service("SysAppBannerP00Service")
public class S extends LKApiBusGetPageService<I, O, SysAppBannerEntity> {

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
		sql.select(SysAppBannerR.id);
		sql.select(SysAppBannerR.insertTime);
		sql.select(SysAppBannerR.locale);
		sql.select(SysAppBannerR.versions);
		sql.select(SysAppBannerR.title);
		sql.select(SysAppBannerR.keywords);
		sql.select(SysAppBannerR.author);
		sql.select(SysAppBannerR.linkUrl);
		sql.select(SysAppBannerR.orderId);
		sql.select(SysAppBannerR.publishTime);
		sql.select(SysAppBannerR.banner);

		// 关联表

		// 字典表
		int i = 0;
		LKDictUtils4App.newsUsingStatus(sql, SysAppBannerR.usingStatus, i++);
		LKDictUtils4App.appKey(sql, params.getCompId(), SysAppBannerR.appKey, i++);
		LKDictUtils.clientType(sql, SysAppBannerR.clientType, i++);
		LKDictUtils4App.newsCategory(sql, params.getCompId(), SysAppBannerR.categoryCode, i++);
		LKDictUtils4App.newsTemplate(sql, SysAppBannerR.templateCode, i++);

		// 筛选条件（必填项）
//		addConditionId(sql, SysAppBannerR.id, params.getId());
		addConditionLocale(sql, SysAppBannerR.locale, params.getLocale());
		addConditionCompId(true, sql, SysAppBannerR.compId, params.getCompId(), params.getBusCompId());
		addConditionUsingStatus(true, params.getCompId(), sql, SysAppBannerR.usingStatus, params.getUsingStatus(), LKUsingStatusEnum.STAND_BY, LKUsingStatusEnum.USING);

		// 筛选条件（业务项）
		String appKey = sin.getAppKey();
		if (StringUtils.isNotBlank(appKey)) {
			sql.eq(SysAppBannerR.appKey, appKey);
		}

		LKClientTypeEnum clientType = sin.getClientType();
		if (clientType != null) {
			sql.eq(SysAppBannerR.clientType, clientType);
		}

		String categoryCode = sin.getCategoryCode();
		if (StringUtils.isNotBlank(categoryCode)) {
			sql.eq(SysAppBannerR.categoryCode, categoryCode);
		}

		String templateCode = sin.getTemplateCode();
		if (StringUtils.isNotBlank(templateCode)) {
			sql.eq(SysAppBannerR.templateCode, templateCode);
		}

		String title = sin.getTitle();
		if (StringUtils.isNotBlank(title)) {
			sql.like(SysAppBannerR.title, LikeType.ALL, title);
		}

		String keywords = sin.getKeywords();
		if (StringUtils.isNotBlank(keywords)) {
			sql.like(SysAppBannerR.keywords, LikeType.ALL, keywords);
		}

		String author = sin.getAuthor();
		if (StringUtils.isNotBlank(author)) {
			sql.like(SysAppBannerR.author, LikeType.ALL, author);
		}

		// 排序条件
		sql.addOrders(new Order(SysAppBannerR.orderId), new Order(SysAppBannerR.id, false));
	}


	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl}")
	private String filesServerRootUrl;


	@Override
	protected Page<O> afterQuery(I sin, ApiKeyValues<I> params, Page<O> page) {
		List<O> content = page.getContent();
		if (CollectionUtils.isNotEmpty(content)) {
			for (O o : page) {
				o.setBanner(filesServerRootUrl + o.getBanner());
			}
		}
		return page;
	}

}
