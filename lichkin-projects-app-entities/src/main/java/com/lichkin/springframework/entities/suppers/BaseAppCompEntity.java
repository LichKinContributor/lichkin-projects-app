package com.lichkin.springframework.entities.suppers;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.lichkin.framework.defines.annotations.FieldGenerator;
import com.lichkin.framework.defines.entities.I_AppKey;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

/**
 * 公司客户端基础表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@MappedSuperclass
public class BaseAppCompEntity extends BaseCompEntity implements I_AppKey {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 客户端唯一标识 */
	@FieldGenerator(dictionary = true, resultColumn = true, queryCondition = true, updateable = false)
	@Column(length = 128, nullable = false)
	private String appKey;

	/** 客户端类型（枚举） */
	@Enumerated(EnumType.STRING)
	@FieldGenerator(resultColumn = true, queryCondition = true, updateable = false)
	@Column(length = 10, nullable = false)
	private LKClientTypeEnum clientType;

}
