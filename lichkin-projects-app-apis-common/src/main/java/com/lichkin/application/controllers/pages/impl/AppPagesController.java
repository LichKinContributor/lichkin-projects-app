package com.lichkin.application.controllers.pages.impl;

import static com.lichkin.defines.AppStatics.PAGE_URL_APP_ACCUMULATE;
import static com.lichkin.defines.AppStatics.PAGE_URL_APP_PRIVACY_RIGHT_POLICY;
import static com.lichkin.defines.AppStatics.PAGE_URL_APP_SECURITY_CENTER;
import static com.lichkin.defines.AppStatics.PAGE_URL_APP_SERVICE_AGREEMENT;
import static com.lichkin.defines.AppStatics.PAGE_URL_APP_VERSIONS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lichkin.framework.web.annotations.WithoutLogin;
import com.lichkin.springframework.controllers.LKPagesController;
import com.lichkin.springframework.web.beans.LKPage;

@Controller
@RequestMapping("/")
public class AppPagesController extends LKPagesController {

	@WithoutLogin
	@GetMapping({

			PAGE_URL_APP_VERSIONS + MAPPING,

			PAGE_URL_APP_SERVICE_AGREEMENT + MAPPING,

			PAGE_URL_APP_PRIVACY_RIGHT_POLICY + MAPPING,

			PAGE_URL_APP_ACCUMULATE + MAPPING,

			PAGE_URL_APP_SECURITY_CENTER + MAPPING,

	})
	public LKPage linkTo() {
		return null;
	}

}
