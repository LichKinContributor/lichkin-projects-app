package com.lichkin.application.services.impl;

import org.springframework.stereotype.Service;

import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKDBService;

@Service
public class SysAppBannerService extends LKDBService {

	public SysAppBannerEntity findOneById(String id) {
		return dao.findOneById(SysAppBannerEntity.class, id);
	}

}
