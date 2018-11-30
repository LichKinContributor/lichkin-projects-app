package com.lichkin.application.apis.ROOT.AddAppVersion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lichkin.application.services.bus.impl.SysAppVersionBusService;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusInsertService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusInsertService<I, SysAppVersionEntity> {

	@Autowired
	private SysAppVersionBusService busService;


	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		SysAppVersion_EXIST(40000),

		;

		private final Integer code;

	}


	@Override
	protected List<SysAppVersionEntity> findExist(I sin, ApiKeyValues<I> params) {
		return busService.findExist(params, sin.getAppKey(), sin.getClientType(), sin.getVersionX(), sin.getVersionY(), sin.getVersionZ());
	}


	@Override
	protected boolean forceCheck(I sin, ApiKeyValues<I> params) {
		return true;
	}


	@Override
	protected LKCodeEnum existErrorCode(I sin, ApiKeyValues<I> params) {
		return ErrorCodes.SysAppVersion_EXIST;
	}


	@Override
	protected void beforeAddNew(I sin, ApiKeyValues<I> params, SysAppVersionEntity entity) {
		entity.setUsingStatus(LKUsingStatusEnum.STAND_BY);
	}

}
