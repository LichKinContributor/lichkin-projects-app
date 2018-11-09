package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.framework.defines.annotations.ClassGenerator;
import com.lichkin.framework.defines.annotations.FieldGenerator;
import com.lichkin.framework.defines.annotations.InsertCheckType;
import com.lichkin.framework.defines.annotations.InsertType;
import com.lichkin.framework.defines.annotations.UpdateCheckType;
import com.lichkin.springframework.entities.suppers.BaseAppEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端版本信息表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
@ClassGenerator(

		afterSaveMain = false

		, insertCheckType = InsertCheckType.FORCE_CHECK

		, updateCheckType = UpdateCheckType.UNCHECK

)
public class SysAppVersionEntity extends BaseAppEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60001L;

	/** 强制更新（true:强制更新;false:不强制更新.） */
	@FieldGenerator(resultColumn = true)
	@Column(nullable = false)
	private Boolean forceUpdate;

	/** 版本信息 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 64, nullable = false)
	private String tip;

	/** 版本信息页面地址 */
	@FieldGenerator(resultColumn = true)
	@Column(length = 128, nullable = false)
	private String url;

	/** 发布时间（yyyyMMddHHmmssSSS） */
	@FieldGenerator(resultColumn = true, updateable = false, insertType = InsertType.DEFAULT_DEFAULT)
	@Column(length = 17)
	private String publishTime;

}
