package com.lichkin.application.apis.api60002.I.n00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.application.services.bus.impl.SysAppBannerBusService;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKApiBusInsertWithoutCheckerService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service("SysAppBannerI00Service")
public class S extends LKApiBusInsertWithoutCheckerService<I, SysAppBannerEntity> {

	@Autowired
	private SysAppBannerBusService busService;


	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		;

		private final Integer code;

	}


	@Override
	protected void beforeAddNew(I sin, ApiKeyValues<I> params, SysAppBannerEntity entity) {
		entity.setUsingStatus(LKUsingStatusEnum.STAND_BY);
	}


	@Override
	protected void beforeSaveMain(I sin, ApiKeyValues<I> params, SysAppBannerEntity entity) {
		entity.setVersions(busService.analysisVersions(sin.getVersions()));
		entity.setCategoryCode(busService.analysisCategoryCode(sin.getCategoryCode()));
		entity.setContent(busService.analysisContent(true, entity, sin.getContent()));
		entity.setBanner(busService.analysisBanner(sin.getBanner()));
	}

}
