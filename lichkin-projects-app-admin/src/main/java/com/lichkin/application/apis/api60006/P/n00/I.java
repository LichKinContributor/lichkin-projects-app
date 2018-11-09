package com.lichkin.application.apis.api60006.P.n00;

import com.lichkin.framework.beans.impl.LKRequestPageBean;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestPageBean {

	private LKUsingStatusEnum usingStatus;

	private String appKey;

	private LKClientTypeEnum clientType;

	/** 开始日期 */
	private String startDate;

	/** 结束日期 */
	private String endDate;

}
