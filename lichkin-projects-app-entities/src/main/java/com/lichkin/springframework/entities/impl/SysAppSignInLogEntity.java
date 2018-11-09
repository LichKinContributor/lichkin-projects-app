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
 * 客户端签到记录表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
@ClassGenerator(

		afterSaveMain = false

		, insertCheckType = InsertCheckType.UNCHECK

		, updateCheckType = UpdateCheckType.UNCHECK

		, pageQueryConditions = { "String startDate 开始日期", "String endDate 结束日期" }

		, pageResultColumns = { "String loginName 登录名 SysUserLoginR", "String cellphone 手机号码 SysUserLoginR" }

)
public class SysAppSignInLogEntity extends BaseAppEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60006L;

	/** 登录ID */
	@FieldGenerator()
	@Column(length = 64, nullable = false)
	private String loginId;

	/** 国际化编码 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 5, nullable = false)
	private String locale;

	/** 签到日期（yyyy-MM-dd） */
	@FieldGenerator(resultColumn = true)
	@Column(length = 10, nullable = false)
	private String signDate;

}
