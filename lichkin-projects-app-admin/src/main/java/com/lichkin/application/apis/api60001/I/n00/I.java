package com.lichkin.application.apis.api60001.I.n00;

import com.lichkin.framework.beans.impl.LKRequestBean;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestBean {

	private String appKey;

	private LKClientTypeEnum clientType;

	private Byte versionX;

	private Byte versionY;

	private Short versionZ;

	private Boolean forceUpdate;

	private String tip;

	private String url;

}
