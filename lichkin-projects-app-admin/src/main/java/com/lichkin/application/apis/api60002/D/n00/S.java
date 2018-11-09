package com.lichkin.application.apis.api60002.D.n00;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.SysAppBannerR;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKApiBusDeleteService;

@Service("SysAppBannerD00Service")
public class S extends LKApiBusDeleteService<I, SysAppBannerEntity> {

	@Override
	protected int getIdColumnResId() {
		return SysAppBannerR.id;
	}


	@Override
	protected boolean realDelete(I sin, String locale, String compId, String loginId) {
		return true;
	}


	@Override
	protected void beforeRealDelete(I sin, String locale, String compId, String loginId, SysAppBannerEntity entity, String id) {
		LKUsingStatusEnum usingStatus = entity.getUsingStatus();
		switch (usingStatus) {
			case STAND_BY:// 待发布
			break;
			default:
				throw new LKRuntimeException(LKErrorCodesEnum.PARAM_ERROR);
		}
	}

}
