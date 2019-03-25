package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.framework.defines.annotations.DefaultBooleanValue;
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
public class SysAppVersionEntity extends BaseAppEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60001L;

	/** 强制更新（true:强制更新;false:不强制更新.） */
	@Column(nullable = false)
	private Boolean forceUpdate;

	/** 是否挂起（true:挂起;false:不挂起.） */
	@DefaultBooleanValue(value = false)
	@Column(nullable = false)
	private Boolean hangUp;

	/** 版本信息 */
	@Column(length = 64, nullable = false)
	private String tip;

	/** 版本信息页面地址 */
	@Column(length = 128, nullable = false)
	private String url;

	/** 发布时间（yyyyMMddHHmmssSSS） */
	@Column(length = 17)
	private String publishTime;

}
