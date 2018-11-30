package com.lichkin.application.apis.ROOT.GetAppSignInLogPage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.application.utils.LKDictUtils4App;
import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppSignInLogR;
import com.lichkin.framework.db.beans.SysUserLoginR;
import com.lichkin.framework.db.enums.LikeType;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppSignInLogEntity;
import com.lichkin.springframework.entities.impl.SysUserLoginEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetPageService<I, O, SysAppSignInLogEntity> {

	@Override
	protected void initSQL(I sin, ApiKeyValues<I> params, QuerySQL sql) {
		// 主表
		sql.select(SysAppSignInLogR.id);
		sql.select(SysAppSignInLogR.insertTime);
		sql.select(SysAppSignInLogR.versionX);
		sql.select(SysAppSignInLogR.versionY);
		sql.select(SysAppSignInLogR.versionZ);
		sql.select(SysAppSignInLogR.locale);

		sql.select(SysAppSignInLogR.signDate);

		// 关联表
		sql.leftJoin(SysUserLoginEntity.class, new Condition(SysUserLoginR.id, SysAppSignInLogR.loginId));
		sql.select(SysUserLoginR.loginName);
		sql.select(SysUserLoginR.cellphone);
		sql.select(SysUserLoginR.userName);

		// 字典表
		int i = 0;
		LKDictUtils.usingStatus(sql, SysAppSignInLogR.usingStatus, i++);
		LKDictUtils4App.appKey(sql, params.getCompId(), SysAppSignInLogR.appKey, i++);
		LKDictUtils.clientType(sql, SysAppSignInLogR.clientType, i++);

		// 筛选条件（业务项）
		String appKey = sin.getAppKey();
		if (StringUtils.isNotBlank(appKey)) {
			sql.eq(SysAppSignInLogR.appKey, appKey);
		}

		LKClientTypeEnum clientType = sin.getClientType();
		if (clientType != null) {
			sql.eq(SysAppSignInLogR.clientType, clientType);
		}

		String startDate = sin.getStartDate();
		if (StringUtils.isNotBlank(startDate)) {
			sql.gte(SysAppSignInLogR.insertTime, LKDateTimeUtils.toString(LKDateTimeUtils.toDateTime(startDate, LKDateTimeTypeEnum.DATE_ONLY), LKDateTimeTypeEnum.TIMESTAMP_MIN));
		}

		String endDate = sin.getEndDate();
		if (StringUtils.isNotBlank(endDate)) {
			sql.lt(SysAppSignInLogR.insertTime, LKDateTimeUtils.toString(LKDateTimeUtils.toDateTime(endDate, LKDateTimeTypeEnum.DATE_ONLY).plusDays(1), LKDateTimeTypeEnum.TIMESTAMP_MIN));
		}

		String loginName = sin.getLoginName();
		if (StringUtils.isNotBlank(loginName)) {
			sql.like(SysUserLoginR.loginName, LikeType.ALL, loginName);
		}

		String cellphone = sin.getCellphone();
		if (StringUtils.isNotBlank(cellphone)) {
			sql.like(SysUserLoginR.cellphone, LikeType.RIGHT, cellphone);
		}

		// 排序条件
		sql.addOrders(new Order(SysAppSignInLogR.id, false));
	}

}
