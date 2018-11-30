package com.lichkin.application.apis.GetDynamicTabs;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysCompR;
import com.lichkin.framework.db.beans.SysEmployeeR;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysCompEntity;
import com.lichkin.springframework.entities.impl.SysEmployeeEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetListService<I, O, SysCompEntity> {

	@Override
	protected void initSQL(I sin, ApiKeyValues<I> params, QuerySQL sql) {
		// 主表
		sql.select(SysCompR.token, "tabId");
		sql.select(SysCompR.abbreviation, "tabName");
		sql.select(SysCompR.photo, "tabIcon");

		// 关联表
		sql.innerJoin(SysEmployeeEntity.class,

				new Condition(null, new eq(SysEmployeeR.id, params.getLoginId())),

				new Condition(null, new eq(SysEmployeeR.usingStatus, LKUsingStatusEnum.USING))

		);

		// 字典表
//		int i = 0;

		// 筛选条件（必填项）
//		addConditionId(sql, SysCompR.id, params.getId());
//		addConditionLocale(sql, SysCompR.locale, params.getLocale());
//		addConditionCompId(true, sql, SysCompR.compId, params.getCompId(), params.getBusCompId());
		addConditionUsingStatus(true, params.getCompId(), sql, SysCompR.usingStatus, params.getUsingStatus(), LKUsingStatusEnum.STAND_BY, LKUsingStatusEnum.USING);

		// 排序条件
		sql.addOrders(new Order(SysCompR.id));
	}

}
