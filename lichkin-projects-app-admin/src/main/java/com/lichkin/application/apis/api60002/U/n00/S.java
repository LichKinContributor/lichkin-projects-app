package com.lichkin.application.apis.api60002.U.n00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.application.services.bus.impl.SysAppBannerBusService;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKApiBusUpdateWithoutCheckerService;

@Service("SysAppBannerU00Service")
public class S extends LKApiBusUpdateWithoutCheckerService<I, SysAppBannerEntity> {

	@Autowired
	private SysAppBannerBusService busService;


	@Override
	protected void beforeSaveMain(I sin, String locale, String compId, String loginId, SysAppBannerEntity entity) {
		entity.setVersions(busService.analysisVersions(sin.getVersions()));
		entity.setCategoryCode(busService.analysisCategoryCode(sin.getCategoryCode()));
		entity.setContent(busService.analysisContent(false, entity, sin.getContent()));
		entity.setBanner(busService.analysisBanner(sin.getBanner()));
	}

}
