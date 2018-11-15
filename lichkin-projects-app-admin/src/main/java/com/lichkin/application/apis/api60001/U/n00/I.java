package com.lichkin.application.apis.api60001.U.n00;

import com.lichkin.framework.beans.impl.LKRequestIDBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestIDBean {

//	private String appKey;

//	private LKClientTypeEnum clientType;

//	private Byte versionX;

//	private Byte versionY;

//	private Short versionZ;

	private Boolean forceUpdate;

	private Boolean hangUp;

	private String tip;

	private String url;

}
