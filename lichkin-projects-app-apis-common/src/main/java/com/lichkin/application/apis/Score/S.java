package com.lichkin.application.apis.Score;

import org.springframework.stereotype.Service;

import com.lichkin.springframework.entities.impl.SysAppScoreEntity;
import com.lichkin.springframework.services.LKApiBusInsertWithoutCheckerService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusInsertWithoutCheckerService<I, SysAppScoreEntity> {

}
