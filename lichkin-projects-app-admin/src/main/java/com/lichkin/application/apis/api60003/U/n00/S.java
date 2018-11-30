package com.lichkin.application.apis.api60003.U.n00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.application.services.bus.impl.SysAppNewsBusService;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.services.LKApiBusUpdateWithoutCheckerService;

@Service("SysAppNewsU00Service")
public class S extends LKApiBusUpdateWithoutCheckerService<I, SysAppNewsEntity> {

	@Autowired
	private SysAppNewsBusService busService;


	@Override
	protected void beforeSaveMain(I sin, ApiKeyValues<I> params, SysAppNewsEntity entity) {
		entity.setVersions(busService.analysisVersions(sin.getVersions()));
		entity.setCategoryCode(busService.analysisCategoryCode(sin.getCategoryCode()));
		entity.setContent(busService.analysisContent(false, entity, sin.getContent()));
	}

}
