package com.lichkin.application.apis.GetNewsPage;

import com.lichkin.framework.beans.impl.LKRequestPageBean;
import com.lichkin.framework.constraints.Word;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestPageBean {

	/** 分类编码 */
	@Word
	private String categoryCode;

}
