package com.lichkin.application.apis.GetLastAppVersion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.lichkin.framework.beans.impl.LKRequestBean;
import com.lichkin.framework.constraints.Text;
import com.lichkin.framework.constraints.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestBean {

	/** 系统版本 */
	@Text
	@Size(max = 16)
	@NotBlank
	private String osVersion;

	/** 生产厂商 */
	@Text
	@Size(max = 64)
	@NotBlank
	private String brand;

	/** 机型信息 */
	@Text
	@Size(max = 128)
	@NotBlank
	private String model;

	/** 设备唯一标识 */
	@UUID
	@NotBlank
	private String uuid;

	/** 屏幕宽 */
	@Positive
	@NotNull
	private Short screenWidth;

	/** 屏幕高 */
	@Positive
	@NotNull
	private Short screenHeight;

}
