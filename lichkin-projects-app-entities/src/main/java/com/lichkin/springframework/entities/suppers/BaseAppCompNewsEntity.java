package com.lichkin.springframework.entities.suppers;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

import com.lichkin.framework.defines.annotations.DefaultByteValue;
import com.lichkin.framework.defines.annotations.DefaultStringValue;
import com.lichkin.framework.defines.annotations.FieldGenerator;
import com.lichkin.framework.defines.annotations.InsertType;

import lombok.Getter;
import lombok.Setter;

/**
 * 公司客户端基础表实体类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@Getter
@Setter
@MappedSuperclass
public class BaseAppCompNewsEntity extends BaseAppCompEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/** 录入人登录ID */
	@FieldGenerator(updateable = false)
	@Column(length = 64, nullable = false)
	private String loginId;

	/** 国际化编码 */
	@FieldGenerator(resultColumn = true, queryCondition = true, updateable = false)
	@Column(length = 5, nullable = false)
	private String locale;

	/** 版本号（分号拼接x.y.z） */
	@DefaultStringValue
	@FieldGenerator(resultColumn = true, insertType = InsertType.CHANGE_HANDLE)
	@Column(length = 1024, nullable = false)
	private String versions;

	/** 分类编码（字典） */
	@DefaultStringValue
	@FieldGenerator(dictionary = true, resultColumn = true, queryCondition = true, insertType = InsertType.CHANGE_HANDLE)
	@Column(length = 64, nullable = false)
	private String categoryCode;

	/** 模板编码（字典） */
	@DefaultStringValue
	@FieldGenerator(dictionary = true, resultColumn = true, queryCondition = true, insertType = InsertType.DEFAULT_RETAIN, updateable = false)
	@Column(length = 64, nullable = false)
	private String templateCode;

	/** 标题（超出...） */
	@FieldGenerator(resultColumn = true, queryCondition = true)
	@Column(length = 64, nullable = false)
	private String title;

	/** 简介（超出...） */
	@DefaultStringValue
	@FieldGenerator()
	@Column(length = 128)
	private String brief;

	/** 关键字（逗号拼接） */
	@DefaultStringValue
	@FieldGenerator(resultColumn = true, queryCondition = true)
	@Column(length = 64)
	private String keywords;

	/** 作者姓名 */
	@FieldGenerator(resultColumn = true, queryCondition = true)
	@Column(length = 64)
	private String author;

	/** 内容（body内直接可以用于展现的内容） */
	@Lob
	@FieldGenerator(insertType = InsertType.CHANGE_HANDLE)
	@Column
	private String content;

	/** 外链地址 */
	@DefaultStringValue
	@FieldGenerator(resultColumn = true)
	@Column(length = 512)
	private String linkUrl;

	/** 排序号 */
	@DefaultByteValue
	@FieldGenerator()
	@Column(nullable = false)
	private Byte orderId;

	/** 发布时间（yyyyMMddHHmmssSSS） */
	@FieldGenerator(resultColumn = true, updateable = false, insertType = InsertType.DEFAULT_DEFAULT)
	@Column(length = 17)
	private String publishTime;

}
