package com.lichkin.application.controllers.pages.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lichkin.application.services.impl.SysAppBannerService;
import com.lichkin.defines.AppStatics;
import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.framework.utils.LKHtmlUtils;
import com.lichkin.framework.web.annotations.WithoutLogin;
import com.lichkin.springframework.controllers.LKPagesController;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.web.beans.LKPage;

@Controller
public class SysAppBannerDetailPageController extends LKPagesController {

	@Autowired
	private SysAppBannerService service;

	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl:http://files.lichkin.com}")
	private String filesServerRootUrl;


	@WithoutLogin
	@GetMapping(AppStatics.PAGE_URL_APP_BANNER + MAPPING)
	public LKPage linkTo(String id) {
		SysAppBannerEntity entity = service.findOneById(id);
		entity.setPublishTime(LKDateTimeUtils.toString(LKDateTimeUtils.toDateTime(entity.getPublishTime()), LKDateTimeTypeEnum.STANDARD));
		if (StringUtils.isNotBlank(entity.getContent())) {
			entity.setContent(LKHtmlUtils.replaceImgTag_src(entity.getContent(), filesServerRootUrl));
		}
		LKPage mv = new LKPage(entity.getTemplateCode());
		mv.putAttribute("entity", entity);
		return mv;
	}

}
