package com.lichkin.application.apis.GetDynamicTabs;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysCompR;
import com.lichkin.framework.db.beans.SysEmployeeR;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.entities.impl.SysCompEntity;
import com.lichkin.springframework.entities.impl.SysEmployeeEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetListService<I, O, SysCompEntity> {

	@Override
	protected void initSQL(I sin, String locale, String compId, String loginId, QuerySQL sql) {
		sql.select(SysCompR.token, "tabId");
		sql.select(SysCompR.compName, "tabName");
		sql.select(SysCompR.photo, "tabIcon");

		sql.innerJoin(SysEmployeeEntity.class,

				new Condition(null, new eq(SysEmployeeR.id, loginId)),

				new Condition(null, new eq(SysEmployeeR.usingStatus, LKUsingStatusEnum.USING))

		);

		sql.eq(SysCompR.usingStatus, LKUsingStatusEnum.USING);

		sql.addOrders(new Order(SysCompR.id));
	}

}
