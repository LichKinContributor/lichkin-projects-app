package com.lichkin.application.apis.Feedback;

import org.springframework.stereotype.Service;

import com.lichkin.framework.utils.LKBeanUtils;
import com.lichkin.springframework.entities.impl.SysAppFeedbackEntity;
import com.lichkin.springframework.services.LKApiBusInsertWithoutCheckerService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusInsertWithoutCheckerService<I, SysAppFeedbackEntity> {

	@Override
	protected void beforeSaveMain(I sin, String locale, String compId, String loginId, SysAppFeedbackEntity entity) {
		LKBeanUtils.copyProperties(sin.getDatas(), entity);
	}

}
