package com.lichkin.springframework.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.lichkin.framework.defines.annotations.ClassGenerator;
import com.lichkin.framework.defines.annotations.FieldGenerator;
import com.lichkin.framework.defines.annotations.InsertCheckType;
import com.lichkin.framework.defines.annotations.InsertType;
import com.lichkin.framework.defines.annotations.UpdateCheckType;
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
@ClassGenerator(

		afterSaveMain = false

		, insertCheckType = InsertCheckType.UNCHECK

		, updateCheckType = UpdateCheckType.UNCHECK

)
public class SysAppBannerEntity extends BaseAppCompNewsEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 60002L;

	/** 图片（URL） */
	@FieldGenerator(insertType = InsertType.CHANGE_HANDLE, resultColumn = true)
	@Column(length = 512, nullable = false)
	private String banner;

}
