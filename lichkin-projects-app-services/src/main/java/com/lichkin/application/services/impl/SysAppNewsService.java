package com.lichkin.application.services.impl;

import org.springframework.stereotype.Service;

import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.services.LKDBService;

@Service
public class SysAppNewsService extends LKDBService {

	public SysAppNewsEntity findOneById(String id) {
		return dao.findOneById(SysAppNewsEntity.class, id);
	}

}
