package com.lichkin.application.apis.api60003.US.n00;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.SysAppNewsR;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.services.LKApiBusUpdateUsingStatusService;

@Service("SysAppNewsUS00Service")
public class S extends LKApiBusUpdateUsingStatusService<I, SysAppNewsEntity> {

	@Override
	protected int getIdColumnResId() {
		return SysAppNewsR.id;
	}


	@Override
	protected void beforeSaveMain(I sin, ApiKeyValues<I> params, SysAppNewsEntity entity, String id) {
		if (LKUsingStatusEnum.STAND_BY.equals(entity.getUsingStatus())) {
			// 待发布 -> 已发布
			entity.setTemplateCode(sin.getTemplateCode());
			entity.setPublishTime(LKDateTimeUtils.now());
			return;
		}
		throw new LKRuntimeException(LKErrorCodesEnum.PARAM_ERROR);
	}

}
