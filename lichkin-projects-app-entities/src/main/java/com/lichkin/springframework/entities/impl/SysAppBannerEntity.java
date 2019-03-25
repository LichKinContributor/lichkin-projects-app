package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.BaseAppCompNewsEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端轮播信息表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysAppBannerEntity extends BaseAppCompNewsEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60002L;

	/** 图片（URL） */
	@Column(length = 512, nullable = false)
	private String banner;

}
