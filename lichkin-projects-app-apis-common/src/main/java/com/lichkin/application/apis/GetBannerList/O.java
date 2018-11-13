package com.lichkin.application.apis.GetBannerList;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class O {

	/** 图片URL */
	private final String imageUrl;

	/** 页面地址 */
	private final String pageUrl;

	/** 标题 */
	private final String title;

}
