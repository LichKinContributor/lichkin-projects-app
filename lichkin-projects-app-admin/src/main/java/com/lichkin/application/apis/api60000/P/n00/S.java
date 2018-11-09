package com.lichkin.application.apis.api60000.P.n00;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppApiRequestLogR;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.db.beans.SysUserLoginR;
import com.lichkin.framework.db.enums.LikeType;
import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.entities.impl.SysAppApiRequestLogEntity;
import com.lichkin.springframework.entities.impl.SysUserLoginEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service("SysAppApiRequestLogP00Service")
public class S extends LKApiBusGetPageService<I, O, SysAppApiRequestLogEntity> {

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
		sql.select(SysAppApiRequestLogR.id);
		sql.select(SysAppApiRequestLogR.insertTime);
		sql.select(SysAppApiRequestLogR.loginId);
		sql.select(SysAppApiRequestLogR.locale);
		sql.select(SysAppApiRequestLogR.osVersion);
		sql.select(SysAppApiRequestLogR.brand);
		sql.select(SysAppApiRequestLogR.model);
		sql.select(SysAppApiRequestLogR.uuid);
		sql.select(SysAppApiRequestLogR.screenWidth);
		sql.select(SysAppApiRequestLogR.screenHeight);

		// 关联表
		sql.leftJoin(SysUserLoginEntity.class, new Condition(SysUserLoginR.id, SysAppApiRequestLogR.loginId));
		sql.select(SysUserLoginR.userName);
		sql.select(SysUserLoginR.cellphone);

		// 字典表
		int i = 0;
		LKDictUtils.usingStatus(sql, SysAppApiRequestLogR.usingStatus, i++);

		// 筛选条件（必填项）
		// 在用状态
		LKUsingStatusEnum usingStatus = sin.getUsingStatus();
		if (usingStatus == null) {
			if (LKFrameworkStatics.LichKin.equals(compId)) {
				sql.neq(SysAppApiRequestLogR.usingStatus, LKUsingStatusEnum.DEPRECATED);
			} else {
				sql.eq(SysAppApiRequestLogR.usingStatus, LKUsingStatusEnum.USING);
			}
		} else {
			sql.eq(SysAppApiRequestLogR.usingStatus, usingStatus);
		}

		// 筛选条件（业务项）
		String appKey = sin.getAppKey();
		if (StringUtils.isNotBlank(appKey)) {
			sql.eq(SysAppVersionR.appKey, appKey);
		}

		LKClientTypeEnum clientType = sin.getClientType();
		if (clientType != null) {
			sql.eq(SysAppApiRequestLogR.clientType, clientType);
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
		sql.addOrders(new Order(SysAppApiRequestLogR.id, false));
	}

}
