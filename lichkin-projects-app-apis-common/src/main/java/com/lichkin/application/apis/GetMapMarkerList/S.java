package com.lichkin.application.apis.GetMapMarkerList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.springframework.configs.LKApplicationContext;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.services.LKApiService;
import com.lichkin.springframework.services.LKApiServiceImpl;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiServiceImpl<I, List<O>> implements LKApiService<I, List<O>> {

	@Override
	public List<O> handle(I cin, ApiKeyValues<I> params) throws LKException {
		return ((SInterface) LKApplicationContext.getBean("GetMapMarkerListS_" + cin.getKey())).handle(cin, params);
	}

}
