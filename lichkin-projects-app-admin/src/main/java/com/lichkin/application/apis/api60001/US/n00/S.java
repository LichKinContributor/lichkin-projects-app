package com.lichkin.application.apis.api60001.US.n00;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusUpdateUsingStatusService;

@Service("SysAppVersionUS00Service")
public class S extends LKApiBusUpdateUsingStatusService<I, SysAppVersionEntity> {

	@Override
	protected int getIdColumnResId() {
		return SysAppVersionR.id;
	}


	@Override
	protected void beforeSaveMain(I sin, String locale, String compId, String loginId, SysAppVersionEntity entity, String id) {
		if (LKUsingStatusEnum.STAND_BY.equals(entity.getUsingStatus()) && LKUsingStatusEnum.USING.equals(sin.getUsingStatus())) {
			// 待发布 -> 已发布
			entity.setPublishTime(LKDateTimeUtils.now());
			return;
		}
		throw new LKRuntimeException(LKErrorCodesEnum.PARAM_ERROR);
	}

}
