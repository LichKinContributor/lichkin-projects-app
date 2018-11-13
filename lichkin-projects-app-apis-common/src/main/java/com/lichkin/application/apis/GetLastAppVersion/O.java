package com.lichkin.application.apis.GetLastAppVersion;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class O {

	/** 强制更新 */
	private boolean forceUpdate;

	/** 客户端版本号（大版本号） */
	private byte versionX;

	/** 客户端版本号（中版本号） */
	private byte versionY;

	/** 客户端版本号（小版本号） */
	private short versionZ;

	/** 版本提示信息 */
	private String tip;

	/** 版本信息页面地址 */
	private String url;

}
