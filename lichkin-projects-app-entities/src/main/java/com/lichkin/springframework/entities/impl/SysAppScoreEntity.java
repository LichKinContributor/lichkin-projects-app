package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.framework.defines.entities.I_Locale;
import com.lichkin.framework.defines.entities.I_LoginId;
import com.lichkin.springframework.entities.suppers.BaseAppEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端评分信息表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysAppScoreEntity extends BaseAppEntity implements I_LoginId, I_Locale {

	/** serialVersionUID */
	private static final long serialVersionUID = 60004L;

	/** 登录前用户不设置值；登录后用户设置登录ID。 */
	@Column(length = 64)
	private String loginId;

	/** 国际化编码 */
	@Column(length = 5, nullable = false)
	private String locale;

	/** 标题 */
	@Column(length = 32)
	private String title;

	/** 评分内容 */
	@Column(length = 1024)
	private String content;

	/** 评分（按照星级评分1~5分 ） */
	@Column(nullable = false)
	private Byte score;

}
