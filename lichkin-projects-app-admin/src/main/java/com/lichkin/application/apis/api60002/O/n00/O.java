package com.lichkin.application.apis.api60002.O.n00;

import com.lichkin.framework.defines.annotations.IgnoreLog;
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

	private String versions;

	private String categoryCode;

	private String templateCode;

	private String title;

	private String brief;

	private String keywords;

	private String author;

	@IgnoreLog
	private String content;

	private String linkUrl;

	private Byte orderId;

	private String publishTime;

	@IgnoreLog
	private String banner;

}
