package com.lichkin.application.apis.GetBanner;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lichkin.framework.utils.LKHtmlUtils;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKApiBusGetOneService;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusGetOneService<I, O, SysAppBannerEntity> {

	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl:http://files.lichkin.com}")
	private String filesServerRootUrl;


	@Override
	protected void setOtherValues(SysAppBannerEntity entity, String id, I sin, ApiKeyValues<I> params, O out) {
		out.setBanner(filesServerRootUrl + out.getBanner());
		if (StringUtils.isNotBlank(entity.getContent())) {
			out.setContent(LKHtmlUtils.replaceImgTag_src(entity.getContent(), filesServerRootUrl));
		}
	}

}
