package com.lichkin.application.apis.GetDynamicTabs;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysCompR;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysCompEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetListService<I, O, SysCompEntity> {

	@Override
	protected void initSQL(I sin, ApiKeyValues<I> params, QuerySQL sql) {
		// 主表
		sql.select(SysCompR.token, "tabId");
		sql.select(SysCompR.abbreviation, "tabName");
		sql.select(SysCompR.photo, "tabIcon");

		// 筛选条件（必填项）
		sql.eq(SysCompR.id, params.getCompId());
		sql.eq(SysCompR.usingStatus, LKUsingStatusEnum.USING);

		// 排序条件
		sql.addOrders(new Order(SysCompR.id));
	}

}
