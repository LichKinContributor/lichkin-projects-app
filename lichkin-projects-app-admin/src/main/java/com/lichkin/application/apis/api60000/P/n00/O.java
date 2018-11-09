package com.lichkin.application.apis.api60000.P.n00;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class O {

	private String id;

	private String usingStatus;

	private String usingStatusDictCode;// for usingStatus

	private String insertTime;

	private String appKey;

	private String clientType;

	private String clientTypeDictCode;// for clientType

	private Byte versionX;

	private Byte versionY;

	private Short versionZ;

	private String loginId;

	private String locale;

	private String osVersion;

	private String brand;

	private String model;

	private String uuid;

	private Short screenWidth;

	private Short screenHeight;

	/** 登录名 */
	private String loginName;

	/** 手机号码 */
	private String cellphone;

}
