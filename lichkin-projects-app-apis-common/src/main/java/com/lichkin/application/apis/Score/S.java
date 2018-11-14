package com.lichkin.application.apis.Score;

import org.springframework.stereotype.Service;

import com.lichkin.springframework.entities.impl.SysAppScoreEntity;
import com.lichkin.springframework.services.LKApiBusInsertWithoutCheckerService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusInsertWithoutCheckerService<I, SysAppScoreEntity> {

	@Override
	protected void beforeSaveMain(I sin, String locale, String compId, String loginId, SysAppScoreEntity entity) {
		entity.setAppKey(sin.getDatas().getAppKey());
	}

}
