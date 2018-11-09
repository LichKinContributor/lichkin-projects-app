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
 * 客户端评分信息表实体类
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
public class SysAppScoreEntity extends BaseAppEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60004L;

	/** 登录前用户不设置值；登录后用户设置登录ID。 */
	@FieldGenerator()
	@Column(length = 64)
	private String loginId;

	/** 国际化编码 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 5, nullable = false)
	private String locale;

	/** 标题 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 32)
	private String title;

	/** 评分内容 */
	@FieldGenerator()
	@Column(length = 1024)
	private String content;

	/** 评分（按照星级评分1~5分 ） */
	@FieldGenerator(resultColumn = true)
	@Column(nullable = false)
	private Byte score;

}
