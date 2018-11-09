package com.lichkin.application.apis.api60001.LD.n01;

import com.lichkin.framework.beans.impl.LKRequestBean;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestBean {

	/** 客户端唯一标识 */
	private String appKey;

	/** 客户端类型 */
	private LKClientTypeEnum clientType;

}
