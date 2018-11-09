package com.lichkin.application.apis.api60003.I.n00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.application.services.bus.impl.SysAppNewsBusService;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.services.LKApiBusInsertWithoutCheckerService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service("SysAppNewsI00Service")
public class S extends LKApiBusInsertWithoutCheckerService<I, SysAppNewsEntity> {

	@Autowired
	private SysAppNewsBusService busService;


	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		;

		private final Integer code;

	}


	@Override
	protected void beforeAddNew(I sin, String locale, String compId, String loginId, SysAppNewsEntity entity) {
		entity.setCompId(getCompId(compId, sin.getCompId()));
		entity.setUsingStatus(LKUsingStatusEnum.STAND_BY);
	}


	@Override
	protected void beforeSaveMain(I sin, String locale, String compId, String loginId, SysAppNewsEntity entity) {
		entity.setVersions(busService.analysisVersions(sin.getVersions()));
		entity.setCategoryCode(busService.analysisCategoryCode(sin.getCategoryCode()));
		entity.setContent(busService.analysisContent(true, entity, sin.getContent()));
		entity.setLoginId(loginId);
		entity.setLocale(locale);
	}

}
