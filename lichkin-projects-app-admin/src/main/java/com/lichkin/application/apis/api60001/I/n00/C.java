package com.lichkin.application.apis.api60001.I.n00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.web.annotations.LKApiType;
import com.lichkin.framework.web.enums.ApiType;
import com.lichkin.springframework.controllers.LKApiBusInsertController;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusInsertService;

@RestController("SysAppVersionI00Controller")
@RequestMapping(value = LKFrameworkStatics.WEB_MAPPING_API_WEB_ADMIN + "/SysAppVersion/I")
@LKApiType(apiType = ApiType.COMPANY_BUSINESS)
public class C extends LKApiBusInsertController<I, SysAppVersionEntity> {

	@Autowired
	private S service;


	@Override
	protected LKApiBusInsertService<I, SysAppVersionEntity> getService(I cin) {
		return service;
	}


	@Override
	protected String getSubOperBusType(I cin) {
		return null;
	}

}
