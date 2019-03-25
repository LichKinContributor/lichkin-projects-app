package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.framework.defines.entities.I_Locale;
import com.lichkin.framework.defines.entities.I_LoginId;
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
public class SysAppSignInLogEntity extends BaseAppEntity implements I_LoginId, I_Locale {

	/** serialVersionUID */
	private static final long serialVersionUID = 60006L;

	/** 登录ID */
	@Column(length = 64, nullable = false)
	private String loginId;

	/** 国际化编码 */
	@Column(length = 5, nullable = false)
	private String locale;

	/** 签到日期（yyyy-MM-dd） */
	@Column(length = 10, nullable = false)
	private String signDate;

}
