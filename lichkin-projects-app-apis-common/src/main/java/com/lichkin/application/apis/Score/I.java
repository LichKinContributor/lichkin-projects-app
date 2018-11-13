package com.lichkin.application.apis.Score;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.lichkin.framework.beans.impl.LKRequestBean;
import com.lichkin.framework.constraints.Text;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestBean {

	/** 评分（按照星级评分1~5分 ） */
	@Positive
	@NotNull
	private Byte score;

	/** 标题 */
	@Text
	@Size(max = 32)
	private String title;

	/** 评分内容 */
	@Text
	@Size(max = 1024)
	private String content;

}
