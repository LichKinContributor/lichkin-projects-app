package com.lichkin.application.apis.GetNewsPage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.framework.defines.exceptions.LKRuntimeException;
import com.lichkin.framework.web.annotations.LKApiType;
import com.lichkin.framework.web.enums.ApiType;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.controllers.LKApiYYController;
import com.lichkin.springframework.services.LKApiService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RestController(Statics.CONTROLLER_NAME)
@RequestMapping(value = LKFrameworkStatics.WEB_MAPPING_API + Statics.SUB_URL)
@LKApiType(apiType = ApiType.COMPANY_QUERY)
public class C extends LKApiYYController<I, Page<O>, Page<O>> {

	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		/** 不是员工 */
		YOU_ARE_NOT_A_EMPLOYEE(29003),

		;

		private final Integer code;

	}


	@Override
	protected boolean saveLog(I cin, ApiKeyValues<I> params) {
		return false;
	}


	@Autowired
	private S service;


	@Override
	protected LKApiService<I, Page<O>> getService(I cin, ApiKeyValues<I> params) {
		return service;
	}


	@Override
	protected void beforeInvokeService(I cin, ApiKeyValues<I> params) throws LKException {
		if (StringUtils.isBlank(cin.getDatas().getToken())) {
			throw new LKRuntimeException(ErrorCodes.YOU_ARE_NOT_A_EMPLOYEE);
		}
	}


	@Override
	protected Page<O> afterInvokeService(I cin, ApiKeyValues<I> params, Page<O> sout) throws LKException {
		return sout;
	}

}
