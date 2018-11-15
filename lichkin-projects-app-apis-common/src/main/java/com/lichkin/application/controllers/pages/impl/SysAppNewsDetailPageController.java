package com.lichkin.application.controllers.pages.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.lichkin.application.services.impl.SysAppNewsService;
import com.lichkin.defines.AppStatics;
import com.lichkin.framework.utils.LKHtmlUtils;
import com.lichkin.framework.web.annotations.WithoutLogin;
import com.lichkin.springframework.controllers.LKPagesController;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;
import com.lichkin.springframework.web.beans.LKPage;

@Controller
public class SysAppNewsDetailPageController extends LKPagesController {

	@Autowired
	private SysAppNewsService service;

	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl}")
	private String filesServerRootUrl;


	@WithoutLogin
	@GetMapping(AppStatics.PAGE_URL_APP_NEWS + MAPPING)
	public LKPage linkTo(String id) {
		SysAppNewsEntity entity = service.findOneById(id);
		if (StringUtils.isNotBlank(entity.getContent())) {
			entity.setContent(LKHtmlUtils.replaceImgTag_src(entity.getContent(), filesServerRootUrl));
		}
		LKPage mv = new LKPage(entity.getTemplateCode());
		mv.putAttribute("entity", entity);
		return mv;
	}

}
