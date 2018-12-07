package com.lichkin.application.apis.GetModuleList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.web.annotations.LKApiType;
import com.lichkin.framework.web.enums.ApiType;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.controllers.LKApiBusGetListController;
import com.lichkin.springframework.entities.impl.SysAppEmployeeModuleConfigEntity;
import com.lichkin.springframework.services.LKApiBusGetListService;

@RestController(Statics.CONTROLLER_NAME)
@RequestMapping(value = LKFrameworkStatics.WEB_MAPPING_API + Statics.SUB_URL)
@LKApiType(apiType = ApiType.COMPANY_BUSINESS)
public class C extends LKApiBusGetListController<I, O, SysAppEmployeeModuleConfigEntity> {

	@Autowired
	private S service;


	@Override
	protected LKApiBusGetListService<I, O, SysAppEmployeeModuleConfigEntity> getService(I cin, ApiKeyValues<I> params) {
		return service;
	}

}
