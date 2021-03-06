package com.lichkin.application.apis.api60002.O.n00;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.beans.impl.LKRequestIDBean;
import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.web.annotations.LKApiType;
import com.lichkin.framework.web.enums.ApiType;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.controllers.LKApiBusGetOneController;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKApiBusGetOneService;

@RestController("SysAppBannerO00Controller")
@RequestMapping(value = LKFrameworkStatics.WEB_MAPPING_API + "/SysAppBanner/O")
@LKApiType(apiType = ApiType.COMPANY_BUSINESS)
public class C extends LKApiBusGetOneController<LKRequestIDBean, O, SysAppBannerEntity> {

	@Autowired
	private S service;


	@Override
	protected LKApiBusGetOneService<LKRequestIDBean, O, SysAppBannerEntity> getService(LKRequestIDBean cin, ApiKeyValues<LKRequestIDBean> params) {
		return service;
	}

}
