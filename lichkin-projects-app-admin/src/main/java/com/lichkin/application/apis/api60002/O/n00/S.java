package com.lichkin.application.apis.api60002.O.n00;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lichkin.framework.beans.impl.LKRequestIDBean;
import com.lichkin.framework.utils.LKHtmlUtils;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKApiBusGetOneService;

@Service("SysAppBannerO00Service")
public class S extends LKApiBusGetOneService<LKRequestIDBean, O, SysAppBannerEntity> {

	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl}")
	private String filesServerRootUrl;


	@Override
	protected void setOtherValues(SysAppBannerEntity entity, String id, LKRequestIDBean sin, ApiKeyValues<LKRequestIDBean> params, O out) {
		out.setBanner(filesServerRootUrl + out.getBanner());

		String content = entity.getContent();
		if (StringUtils.isNotBlank(content)) {
			out.setContent(LKHtmlUtils.replaceImgTag_src(content, filesServerRootUrl));
		}
	}

}
