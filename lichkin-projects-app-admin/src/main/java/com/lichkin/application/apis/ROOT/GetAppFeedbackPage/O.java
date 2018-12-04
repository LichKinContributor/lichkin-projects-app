package com.lichkin.application.apis.ROOT.GetAppFeedbackPage;

import com.lichkin.framework.defines.annotations.IgnoreLog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class O {

	private String id;

	private String usingStatus;

	private String usingStatusDictCode;// for usingStatus

	private String insertTime;

	private String appKey;

	private String clientType;

	private String clientTypeDictCode;// for clientType

	private Byte versionX;

	private Byte versionY;

	private Short versionZ;

	private String locale;

	private String content;

	@IgnoreLog
	private String img;

	/** 登录名 */
	private String loginName;

	/** 手机号码 */
	private String cellphone;

	/** 用户姓名 */
	private String userName;

}
