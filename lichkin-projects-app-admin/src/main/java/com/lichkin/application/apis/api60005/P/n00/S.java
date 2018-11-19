package com.lichkin.application.apis.api60005.P.n00;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.application.utils.LKDictUtils4App;
import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppFeedbackR;
import com.lichkin.framework.db.beans.SysUserLoginR;
import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.springframework.entities.impl.SysAppFeedbackEntity;
import com.lichkin.springframework.entities.impl.SysUserLoginEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service("SysAppFeedbackP00Service")
public class S extends LKApiBusGetPageService<I, O, SysAppFeedbackEntity> {

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
		sql.select(SysAppFeedbackR.id);
		sql.select(SysAppFeedbackR.insertTime);
		sql.select(SysAppFeedbackR.versionX);
		sql.select(SysAppFeedbackR.versionY);
		sql.select(SysAppFeedbackR.versionZ);
		sql.select(SysAppFeedbackR.locale);
		sql.select(SysAppFeedbackR.content);
		sql.select(SysAppFeedbackR.img);

		// 关联表
		sql.leftJoin(SysUserLoginEntity.class, new Condition(SysUserLoginR.id, SysAppFeedbackR.loginId));
		sql.select(SysUserLoginR.loginName);
		sql.select(SysUserLoginR.cellphone);

		// 字典表
		int i = 0;
		LKDictUtils.usingStatus(sql, SysAppFeedbackR.usingStatus, i++);
		LKDictUtils4App.appKey(sql, compId, SysAppFeedbackR.appKey, i++);
		LKDictUtils.clientType(sql, SysAppFeedbackR.clientType, i++);

		// 筛选条件（必填项）
		// 在用状态
		LKUsingStatusEnum usingStatus = sin.getUsingStatus();
		if (usingStatus == null) {
			if (LKFrameworkStatics.LichKin.equals(compId)) {
				sql.neq(SysAppFeedbackR.usingStatus, LKUsingStatusEnum.DEPRECATED);
			} else {
				sql.eq(SysAppFeedbackR.usingStatus, LKUsingStatusEnum.USING);
			}
		} else {
			sql.eq(SysAppFeedbackR.usingStatus, usingStatus);
		}

		// 筛选条件（业务项）
		String appKey = sin.getAppKey();
		if (StringUtils.isNotBlank(appKey)) {
			sql.eq(SysAppFeedbackR.appKey, appKey);
		}

		LKClientTypeEnum clientType = sin.getClientType();
		if (clientType != null) {
			sql.eq(SysAppFeedbackR.clientType, clientType);
		}

		String startDate = sin.getStartDate();
		if (StringUtils.isNotBlank(startDate)) {
			sql.gte(SysAppFeedbackR.insertTime, LKDateTimeUtils.toString(LKDateTimeUtils.toDateTime(startDate, LKDateTimeTypeEnum.DATE_ONLY), LKDateTimeTypeEnum.TIMESTAMP_MIN));
		}

		String endDate = sin.getEndDate();
		if (StringUtils.isNotBlank(endDate)) {
			sql.lt(SysAppFeedbackR.insertTime, LKDateTimeUtils.toString(LKDateTimeUtils.toDateTime(endDate, LKDateTimeTypeEnum.DATE_ONLY).plusDays(1), LKDateTimeTypeEnum.TIMESTAMP_MIN));
		}

		// 排序条件
		sql.addOrders(new Order(SysAppFeedbackR.id, false));
	}

}
