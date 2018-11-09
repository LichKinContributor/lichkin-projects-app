package com.lichkin.application.apis.api60004.P.n00;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.application.utils.LKDictUtils4App;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppNewsR;
import com.lichkin.framework.db.beans.SysAppScoreR;
import com.lichkin.framework.db.beans.SysUserLoginR;
import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.springframework.entities.impl.SysAppScoreEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service("SysAppScoreP00Service")
public class S extends LKApiBusGetPageService<I, O, SysAppScoreEntity> {

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
		sql.select(SysAppScoreR.id);
		sql.select(SysAppScoreR.insertTime);
		sql.select(SysAppScoreR.versionX);
		sql.select(SysAppScoreR.versionY);
		sql.select(SysAppScoreR.versionZ);
		sql.select(SysAppScoreR.locale);
		sql.select(SysAppScoreR.title);
		sql.select(SysAppScoreR.score);

		// 关联表
		sql.select(SysUserLoginR.loginName);
		sql.select(SysUserLoginR.cellphone);

		// 字典表
		int i = 0;
		LKDictUtils.usingStatus(sql, SysAppScoreR.usingStatus, i++);
		LKDictUtils4App.appKey(sql, compId, SysAppScoreR.appKey, i++);
		LKDictUtils.clientType(sql, SysAppScoreR.clientType, i++);

		// 筛选条件（必填项）
		// 在用状态
		LKUsingStatusEnum usingStatus = sin.getUsingStatus();
		if (usingStatus == null) {
			if (LKFrameworkStatics.LichKin.equals(compId)) {
				sql.neq(SysAppScoreR.usingStatus, LKUsingStatusEnum.DEPRECATED);
			} else {
				sql.eq(SysAppScoreR.usingStatus, LKUsingStatusEnum.USING);
			}
		} else {
			sql.eq(SysAppScoreR.usingStatus, usingStatus);
		}

		// 筛选条件（业务项）
		String appKey = sin.getAppKey();
		if (StringUtils.isNotBlank(appKey)) {
			sql.eq(SysAppNewsR.appKey, appKey);
		}

		LKClientTypeEnum clientType = sin.getClientType();
		if (clientType != null) {
			sql.eq(SysAppScoreR.clientType, clientType);
		}

		String startDate = sin.getStartDate();
		if (StringUtils.isNotBlank(startDate)) {
			sql.gte(SysAppScoreR.insertTime, LKDateTimeUtils.toString(LKDateTimeUtils.toDateTime(startDate, LKDateTimeTypeEnum.DATE_ONLY), LKDateTimeTypeEnum.TIMESTAMP_MIN));
		}

		String endDate = sin.getEndDate();
		if (StringUtils.isNotBlank(endDate)) {
			sql.lt(SysAppScoreR.insertTime, LKDateTimeUtils.toString(LKDateTimeUtils.toDateTime(endDate, LKDateTimeTypeEnum.DATE_ONLY).plusDays(1), LKDateTimeTypeEnum.TIMESTAMP_MIN));
		}

		// 排序条件
		sql.addOrders(new Order(SysAppScoreR.id, false));
	}

}
