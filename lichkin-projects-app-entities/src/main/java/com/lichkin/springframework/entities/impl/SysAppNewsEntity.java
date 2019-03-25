package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.springframework.entities.suppers.BaseAppCompNewsEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 客户端新闻信息表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@Entity
public class SysAppNewsEntity extends BaseAppCompNewsEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60003L;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl1;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl2;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl3;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl4;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl5;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl6;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl7;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl8;

	/** 图片（URL） */
	@Column(length = 512)
	private String imageUrl9;
}
