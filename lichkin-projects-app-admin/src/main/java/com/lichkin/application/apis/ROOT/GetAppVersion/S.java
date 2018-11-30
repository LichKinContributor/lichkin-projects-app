package com.lichkin.application.apis.ROOT.GetAppVersion;

import org.springframework.stereotype.Service;

import com.lichkin.framework.beans.impl.LKRequestIDBean;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusGetOneService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetOneService<LKRequestIDBean, O, SysAppVersionEntity> {

}
