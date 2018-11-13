package com.lichkin.application.apis.GetNewsPage;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class O {

	/** 地址 */
	private final String url;

	/** 标题 */
	private final String title;

	/** 简介 */
	private final String brief;

	/** 图片地址 */
	private List<String> imageUrls;

}
