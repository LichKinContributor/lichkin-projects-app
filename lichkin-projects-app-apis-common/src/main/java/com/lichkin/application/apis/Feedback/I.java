package com.lichkin.application.apis.Feedback;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.lichkin.framework.beans.impl.LKRequestBean;
import com.lichkin.framework.constraints.BASE64;
import com.lichkin.framework.constraints.Text;
import com.lichkin.framework.defines.annotations.IgnoreLog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestBean {

	/** 反馈内容 */
	@Text
	@Size(max = 1024)
	@NotBlank
	private String content;

	/** 图片（Base64） */
	@BASE64
	@IgnoreLog
	private String img;

}
