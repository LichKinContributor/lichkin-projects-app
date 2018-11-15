package com.lichkin.application.apis.api60001.O.n00;

import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class O {

	private String id;

	private LKUsingStatusEnum usingStatus;

	private String insertTime;

	private String appKey;

	private LKClientTypeEnum clientType;

	private Byte versionX;

	private Byte versionY;

	private Short versionZ;

	private Boolean forceUpdate;

	private Boolean hangUp;

	private String tip;

	private String url;

	private String publishTime;

}
