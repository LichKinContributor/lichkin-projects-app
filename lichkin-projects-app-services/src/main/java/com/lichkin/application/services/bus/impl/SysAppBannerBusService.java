package com.lichkin.application.services.bus.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.utils.LKFileUtils;
import com.lichkin.framework.utils.LKImageUtils;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;

@Service
public class SysAppBannerBusService {

	public String analysisVersions(String versions) {
		return StringUtils.isBlank(versions) ? "" : LKFrameworkStatics.SPLITOR + versions + LKFrameworkStatics.SPLITOR;
	}


	public String analysisCategoryCode(String categoryCode) {
		return StringUtils.trimToEmpty(categoryCode);
	}


	public String analysisContent(boolean insert, SysAppBannerEntity entity, String content) {
		if (StringUtils.isNotBlank(content)) {
			entity.setLinkUrl("");
			return content.replaceAll(fileServerRootUrl, "");
		} else {
			return null;
		}
	}


	/** 文件服务器保存根路径 */
	@Value("${com.lichkin.files.save.path:/opt/files}")
	private String fileSaveRootPath;

	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl}")
	private String fileServerRootUrl;

	/** 内容中的图片保存子路径 */
	private static final String BANNER_IMAGES_PATH = "/images/banner";


	public String analysisBanner(String banner) {
		if (banner.startsWith("http")) {
			return banner.replace(fileServerRootUrl, "");
		}
		String filePath = LKFileUtils.createFilePath(fileSaveRootPath + BANNER_IMAGES_PATH, ".jpeg");
		new Thread(() -> LKImageUtils.base64ToImage(banner, filePath)).start();
		return filePath.replace(fileSaveRootPath, "");
	}

}
