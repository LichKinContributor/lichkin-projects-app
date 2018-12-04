package com.lichkin.application.apis.api60003.I.n00;

import com.lichkin.framework.beans.impl.LKRequestBean;
import com.lichkin.framework.defines.annotations.IgnoreLog;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestBean {

	private String appKey;

	private LKClientTypeEnum clientType;

	private String versions;

	private String categoryCode;

	private String title;

	private String brief;

	private String keywords;

	private String author;

	@IgnoreLog
	private String content;

	private String linkUrl;

	private Byte orderId;

}
