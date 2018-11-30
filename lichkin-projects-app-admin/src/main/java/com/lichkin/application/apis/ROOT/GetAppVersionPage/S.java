package com.lichkin.application.apis.ROOT.GetAppVersionPage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.application.utils.LKDictUtils4App;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetPageService<I, O, SysAppVersionEntity> {

	@Override
	protected void initSQL(I sin, ApiKeyValues<I> params, QuerySQL sql) {
		// 主表
		sql.select(SysAppVersionR.id);
		sql.select(SysAppVersionR.insertTime);
		sql.select(SysAppVersionR.versionX);
		sql.select(SysAppVersionR.versionY);
		sql.select(SysAppVersionR.versionZ);

		sql.select(SysAppVersionR.forceUpdate);
		sql.select(SysAppVersionR.hangUp);
		sql.select(SysAppVersionR.tip);
		sql.select(SysAppVersionR.url);
		sql.select(SysAppVersionR.publishTime);

		// 字典表
		int i = 0;
		LKDictUtils4App.appVersionUsingStatus(sql, SysAppVersionR.usingStatus, i++);
		LKDictUtils4App.appKey(sql, params.getCompId(), SysAppVersionR.appKey, i++);
		LKDictUtils.clientType(sql, SysAppVersionR.clientType, i++);

		// 筛选条件（业务项）
		String appKey = sin.getAppKey();
		if (StringUtils.isNotBlank(appKey)) {
			sql.eq(SysAppVersionR.appKey, appKey);
		}

		LKClientTypeEnum clientType = sin.getClientType();
		if (clientType != null) {
			sql.eq(SysAppVersionR.clientType, clientType);
		}

		LKUsingStatusEnum usingStatus = sin.getUsingStatus();
		if (usingStatus != null) {
			sql.eq(SysAppVersionR.usingStatus, usingStatus);
		}

		// 排序条件
		sql.addOrders(new Order(SysAppVersionR.id, false));
	}

}
