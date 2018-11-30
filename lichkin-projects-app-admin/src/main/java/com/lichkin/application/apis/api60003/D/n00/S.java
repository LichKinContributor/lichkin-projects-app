package com.lichkin.application.apis.api60003.D.n00;

import org.springframework.stereotype.Service;

import com.lichkin.framework.beans.impl.LKRequestIDsBean;
import com.lichkin.framework.db.beans.SysAppNewsR;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.services.LKApiBusDeleteService;

@Service("SysAppNewsD00Service")
public class S extends LKApiBusDeleteService<LKRequestIDsBean, SysAppNewsEntity> {

	@Override
	protected int getIdColumnResId() {
		return SysAppNewsR.id;
	}


	@Override
	protected void beforeRealDelete(LKRequestIDsBean sin, ApiKeyValues<LKRequestIDsBean> params, SysAppNewsEntity entity, String id) {
		LKUsingStatusEnum usingStatus = entity.getUsingStatus();
		switch (usingStatus) {
			case STAND_BY:// 待发布
			break;
			default:
				throw new LKRuntimeException(LKErrorCodesEnum.PARAM_ERROR);
		}
	}

}
