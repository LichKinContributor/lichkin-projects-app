package com.lichkin.application.apis.GetMapMarkerList;

import java.util.List;

import com.lichkin.springframework.controllers.ApiKeyValues;

public interface SInterface {

	List<O> handle(I cin, ApiKeyValues<I> params);

}
