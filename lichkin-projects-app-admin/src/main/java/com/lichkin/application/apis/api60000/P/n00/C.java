package com.lichkin.application.apis.api60000.P.n00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.web.annotations.LKApiType;
import com.lichkin.framework.web.enums.ApiType;
import com.lichkin.springframework.controllers.LKApiBusGetPageController;
import com.lichkin.springframework.entities.impl.SysAppApiRequestLogEntity;
import com.lichkin.springframework.services.LKApiBusGetPageService;

@RestController("SysAppApiRequestLogP00Controller")
@RequestMapping(value = LKFrameworkStatics.WEB_MAPPING_API_WEB_ADMIN + "/SysAppApiRequestLog/P")
@LKApiType(apiType = ApiType.COMPANY_BUSINESS)
public class C extends LKApiBusGetPageController<I, O, SysAppApiRequestLogEntity> {

	@Autowired
	private S service;


	@Override
	protected LKApiBusGetPageService<I, O, SysAppApiRequestLogEntity> getService(I cin) {
		return service;
	}

}
