package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.framework.defines.annotations.DefaultStringValue;
import com.lichkin.springframework.entities.suppers.IDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端员工模块配置表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysAppEmployeeModuleConfigEntity extends IDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60007L;

	/** 模块类型（字典） */
	@Column(length = 64, nullable = false)
	private String moduleType;

	/** 模块名称 */
	@Column(length = 64, nullable = false)
	private String moduleName;

	/** true:已上线;false:未上线; */
	@Column(nullable = false)
	private Boolean onLine;

	/** true:需要权限;false:不需要权限; */
	@Column(nullable = false)
	private Boolean auth;

	/** 图标 */
	@Column(length = 32)
	private String icon;

	/** 链接地址 */
	@DefaultStringValue
	@Column(length = 128, nullable = false)
	private String url;

}
