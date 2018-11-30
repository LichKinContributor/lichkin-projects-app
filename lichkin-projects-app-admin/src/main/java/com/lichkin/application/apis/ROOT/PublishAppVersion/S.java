package com.lichkin.application.apis.ROOT.PublishAppVersion;

import org.springframework.stereotype.Service;

import com.lichkin.framework.beans.impl.LKRequestIDsBean;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.defines.enums.impl.LKErrorCodesEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusUpdateUsingStatusService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusUpdateUsingStatusService<LKRequestIDsBean, SysAppVersionEntity> {

	@Override
	protected int getIdColumnResId() {
		return SysAppVersionR.id;
	}


	@Override
	protected void beforeSaveMain(LKRequestIDsBean sin, ApiKeyValues<LKRequestIDsBean> params, SysAppVersionEntity entity, String id) {
		if (LKUsingStatusEnum.STAND_BY.equals(entity.getUsingStatus())) {
			// 待发布 -> 已发布
			entity.setPublishTime(LKDateTimeUtils.now());
			return;
		}
		throw new LKRuntimeException(LKErrorCodesEnum.PARAM_ERROR);
	}

}
