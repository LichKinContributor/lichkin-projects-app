package com.lichkin.application.apis.api60003.O.n00;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lichkin.framework.utils.LKHtmlUtils;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.services.LKApiBusGetOneService;

@Service("SysAppNewsO00Service")
public class S extends LKApiBusGetOneService<I, O, SysAppNewsEntity> {

	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl}")
	private String filesServerRootUrl;


	@Override
	protected void setOtherValues(SysAppNewsEntity entity, String id, I sin, String locale, String compId, String loginId, O out) {
		String content = entity.getContent();
		if (StringUtils.isNotBlank(content)) {
			out.setContent(LKHtmlUtils.replaceImgTag_src(content, filesServerRootUrl));
		}
	}

}
