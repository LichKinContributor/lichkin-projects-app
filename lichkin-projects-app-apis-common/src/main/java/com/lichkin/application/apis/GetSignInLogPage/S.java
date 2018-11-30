package com.lichkin.application.apis.GetSignInLogPage;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppSignInLogR;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppSignInLogEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetPageService<I, O, SysAppSignInLogEntity> {

	@Override
	protected void initSQL(I sin, ApiKeyValues<I> params, QuerySQL sql) {
		// 主表
		sql.select(SysAppSignInLogR.signDate);

		// 关联表

		// 字典表
//		int i = 0;

		// 筛选条件（必填项）
//		addConditionId(sql, SysAppSignInLogR.id, params.getId());
//		addConditionLocale(sql, SysAppSignInLogR.locale, params.getLocale());
//		addConditionCompId(true, sql, SysAppSignInLogR.compId, params.getCompId(), params.getBusCompId());
		addConditionUsingStatus(true, params.getCompId(), sql, SysAppSignInLogR.usingStatus, params.getUsingStatus(), LKUsingStatusEnum.USING);

		// 筛选条件（业务项）
		sql.eq(SysAppSignInLogR.loginId, params.getLoginId());

		// 排序条件
		sql.addOrders(new Order(SysAppSignInLogR.signDate, false));
	}

}
