package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.framework.defines.entities.I_Locale;
import com.lichkin.framework.defines.entities.I_LoginId;
import com.lichkin.springframework.entities.suppers.BaseAppEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端接口请求日志表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysAppApiRequestLogEntity extends BaseAppEntity implements I_LoginId, I_Locale {

	/** serialVersionUID */
	private static final long serialVersionUID = 60000L;

	/** 登录前用户不设置值；登录后用户设置登录ID。 */
	@Column(length = 64)
	private String loginId;

	/** 国际化编码 */
	@Column(length = 5, nullable = false)
	private String locale;

	/** 客户端系统版本 */
	@Column(length = 16, nullable = false)
	private String osVersion;

	/** 生产厂商 */
	@Column(length = 64, nullable = false)
	private String brand;

	/** 机型信息 */
	@Column(length = 128, nullable = false)
	private String model;

	/** 设备唯一标识 */
	@Column(length = 64, nullable = false)
	private String uuid;

	/** 屏幕宽 */
	@Column(nullable = false)
	private Short screenWidth;

	/** 屏幕高 */
	@Column(nullable = false)
	private Short screenHeight;

}
