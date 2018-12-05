package com.lichkin.application.apis.Feedback;

import org.springframework.stereotype.Service;

import com.lichkin.springframework.entities.impl.SysAppFeedbackEntity;
import com.lichkin.springframework.services.LKApiBusInsertWithoutCheckerService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusInsertWithoutCheckerService<I, SysAppFeedbackEntity> {

}
