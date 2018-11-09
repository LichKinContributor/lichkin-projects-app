package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.framework.defines.annotations.ClassGenerator;
import com.lichkin.framework.defines.annotations.FieldGenerator;
import com.lichkin.framework.defines.annotations.InsertCheckType;
import com.lichkin.framework.defines.annotations.UpdateCheckType;
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
@ClassGenerator(

		afterSaveMain = false

		, insertCheckType = InsertCheckType.UNCHECK

		, updateCheckType = UpdateCheckType.UNCHECK

		, pageQueryConditions = { "String loginName 登录名 SysUserLoginR", "String cellphone 手机号码 SysUserLoginR" }

		, pageResultColumns = { "String loginName 登录名 SysUserLoginR", "String cellphone 手机号码 SysUserLoginR" }

)
public class SysAppApiRequestLogEntity extends BaseAppEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60000L;

	/** 登录前用户不设置值；登录后用户设置登录ID。 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 64)
	private String loginId;

	/** 国际化编码 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 5, nullable = false)
	private String locale;

	/** 客户端系统版本 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 16, nullable = false)
	private String osVersion;

	/** 生产厂商 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 64, nullable = false)
	private String brand;

	/** 机型信息 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 128, nullable = false)
	private String model;

	/** 设备唯一标识 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 64, nullable = false)
	private String uuid;

	/** 屏幕宽 */
	@FieldGenerator(resultColumn = true)
	@Column(nullable = false)
	private Short screenWidth;

	/** 屏幕高 */
	@FieldGenerator(resultColumn = true)
	@Column(nullable = false)
	private Short screenHeight;

}
