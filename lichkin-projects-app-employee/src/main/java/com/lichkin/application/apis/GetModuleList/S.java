package com.lichkin.application.apis.GetModuleList;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppEmployeeModuleConfigR;
import com.lichkin.framework.db.beans.SysAppEmployeeModuleR;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.db.beans.isNotNull;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppEmployeeModuleConfigEntity;
import com.lichkin.springframework.entities.impl.SysAppEmployeeModuleEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetListService<I, O, SysAppEmployeeModuleConfigEntity> {

	@Override
	protected void initSQL(I cin, ApiKeyValues<I> params, QuerySQL sql) {
		// 主表
		sql.select(SysAppEmployeeModuleConfigR.id);
		sql.select(SysAppEmployeeModuleConfigR.moduleName);
		sql.select(SysAppEmployeeModuleConfigR.icon);
		sql.select(SysAppEmployeeModuleConfigR.url);

		sql.leftJoin(

				SysAppEmployeeModuleEntity.class,

				new Condition(new eq(SysAppEmployeeModuleConfigR.auth, Boolean.TRUE)),

				new Condition(SysAppEmployeeModuleConfigR.id, SysAppEmployeeModuleR.configId),

				new Condition(new eq(SysAppEmployeeModuleR.employeeId, params.getLoginId()))

		);

		// 筛选条件（必填项）
		sql.eq(SysAppEmployeeModuleConfigR.moduleType, cin.getModuleType());
		sql.eq(SysAppEmployeeModuleConfigR.onLine, Boolean.TRUE);
		sql.where(

				new Condition(true,

						new Condition(new isNotNull(SysAppEmployeeModuleR.configId)),

						new Condition(false, new eq(SysAppEmployeeModuleConfigR.auth, Boolean.FALSE))

				)

		);

		// 排序条件
		sql.addOrders(new Order(SysAppEmployeeModuleConfigR.id));
	}

}
