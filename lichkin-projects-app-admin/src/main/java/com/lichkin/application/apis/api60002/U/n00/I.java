package com.lichkin.application.apis.api60002.U.n00;

import com.lichkin.framework.beans.impl.LKRequestIDBean;
import com.lichkin.framework.defines.annotations.IgnoreLog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestIDBean {

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

	@IgnoreLog
	private String banner;

}
