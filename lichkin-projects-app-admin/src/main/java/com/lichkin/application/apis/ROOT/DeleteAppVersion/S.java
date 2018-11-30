package com.lichkin.application.apis.ROOT.DeleteAppVersion;

import org.springframework.stereotype.Service;

import com.lichkin.framework.beans.impl.LKRequestIDsBean;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusDeleteService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusDeleteService<LKRequestIDsBean, SysAppVersionEntity> {

	@Override
	protected int getIdColumnResId() {
		return SysAppVersionR.id;
	}


	@Override
	protected void beforeRealDelete(LKRequestIDsBean sin, ApiKeyValues<LKRequestIDsBean> params, SysAppVersionEntity entity, String id) {
		LKUsingStatusEnum usingStatus = entity.getUsingStatus();
		switch (usingStatus) {
			case STAND_BY:// 待发布
			break;
			default:
				throw new LKRuntimeException(LKErrorCodesEnum.PARAM_ERROR);
		}
	}

}
