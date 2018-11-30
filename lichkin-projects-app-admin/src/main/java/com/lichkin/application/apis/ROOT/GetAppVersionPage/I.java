package com.lichkin.application.apis.ROOT.GetAppVersionPage;

import com.lichkin.framework.beans.impl.LKRequestPageBean;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestPageBean {

	private String appKey;

	private LKClientTypeEnum clientType;

}
