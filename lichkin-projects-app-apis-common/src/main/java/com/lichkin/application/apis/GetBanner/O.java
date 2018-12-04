package com.lichkin.application.apis.GetBanner;

import com.lichkin.framework.defines.annotations.IgnoreLog;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class O {

	/** 主键 */
	private String id;

	/** 客户端唯一标识 */
	private String appKey;

	/** 客户端类型（枚举） */
	private LKClientTypeEnum clientType;

	/** 版本号（分号拼接x.y.z） */
	private String versions;

	/** 分类编码（字典） */
	private String categoryCode;

	/** 模板编码（字典） */
	private String templateCode;

	/** 标题（超出...） */
	private String title;

	/** 简介（超出...） */
	private String brief;

	/** 关键字（逗号拼接） */
	private String keywords;

	/** 作者姓名 */
	private String author;

	/** 内容（body内直接可以用于展现的内容） */
	@IgnoreLog
	private String content;

	/** 外链地址 */
	private String linkUrl;

	/** 排序号 */
	private Byte orderId;

	/** 发布时间（yyyyMMddHHmmssSSS） */
	private String publishTime;

	/** 图片（URL） */
	private String banner;

}
