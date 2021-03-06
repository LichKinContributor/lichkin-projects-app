package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import com.lichkin.framework.defines.annotations.IgnoreLog;
import com.lichkin.framework.defines.entities.I_Locale;
import com.lichkin.framework.defines.entities.I_LoginId;
import com.lichkin.springframework.entities.suppers.BaseAppEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端反馈信息表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysAppFeedbackEntity extends BaseAppEntity implements I_LoginId, I_Locale {

	/** serialVersionUID */
	private static final long serialVersionUID = 60005L;

	/** 登录前用户不设置值；登录后用户设置登录ID。 */
	@Column(length = 64)
	private String loginId;

	/** 国际化编码 */
	@Column(length = 5, nullable = false)
	private String locale;

	/** 反馈内容 */
	@Column(length = 1024, nullable = false)
	private String content;

	/** 反馈图片（Base64） */
	@Lob
	@IgnoreLog
	@Column
	private String img;

}
