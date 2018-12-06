package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.IDEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端员工&amp;模块配置关联表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysAppEmployeeModuleEntity extends IDEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60008L;

	/** 员工ID（SysEmployeeEntity.id） */
	@Column(length = 64, nullable = false)
	private String employeeId;

	/** 员工客户端模块ID（SysEmployeeAppModuleConfigEntity.id） */
	@Column(length = 64, nullable = false)
	private String configId;

}
