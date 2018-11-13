package com.lichkin.application.apis.GetSignInLogPage;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppSignInLogR;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.entities.impl.SysAppSignInLogEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetPageService<I, O, SysAppSignInLogEntity> {

	@Override
	protected void initSQL(I sin, String locale, String compId, String loginId, QuerySQL sql) {
		sql.select(SysAppSignInLogR.signDate);

		sql.eq(SysAppSignInLogR.usingStatus, LKUsingStatusEnum.USING);
		sql.eq(SysAppSignInLogR.loginId, loginId);

		sql.addOrders(new Order(SysAppSignInLogR.signDate, false));
	}

}
