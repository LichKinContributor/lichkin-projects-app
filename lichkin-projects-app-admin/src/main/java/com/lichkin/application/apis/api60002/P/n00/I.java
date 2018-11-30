package com.lichkin.application.apis.api60002.P.n00;

import com.lichkin.framework.beans.impl.LKRequestPageBean;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestPageBean {

	private String appKey;

	private LKClientTypeEnum clientType;

	private String categoryCode;

	private String templateCode;

	private String title;

	private String keywords;

	private String author;

}
