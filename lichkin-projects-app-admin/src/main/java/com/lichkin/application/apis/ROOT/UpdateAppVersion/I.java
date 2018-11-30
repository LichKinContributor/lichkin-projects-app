package com.lichkin.application.apis.ROOT.UpdateAppVersion;

import com.lichkin.framework.beans.impl.LKRequestIDBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestIDBean {

	private Boolean forceUpdate;

	private Boolean hangUp;

	private String tip;

	private String url;

}
