package com.lichkin.application.apis.ROOT.UpdateAppVersion;

import org.springframework.stereotype.Service;

import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusUpdateWithoutCheckerService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusUpdateWithoutCheckerService<I, SysAppVersionEntity> {

}
