package com.lichkin.application.services.bus.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.utils.LKHtmlUtils;
import com.lichkin.framework.utils.LKImageUtils;
import com.lichkin.springframework.entities.impl.SysAppNewsEntity;

@Service
public class SysAppNewsBusService {

	public String analysisVersions(String versions) {
		return StringUtils.isBlank(versions) ? "" : LKFrameworkStatics.SPLITOR + versions + LKFrameworkStatics.SPLITOR;
	}


	public String analysisCategoryCode(String categoryCode) {
		return StringUtils.trimToEmpty(categoryCode);
	}


	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl:http://files.lichkin.com}")
	private String filesServerRootUrl;

	/** 文件服务器保存根路径 */
	@Value("${com.lichkin.files.save.path:/opt/files}")
	private String filesSaveRootPath;


	public String analysisContent(boolean insert, SysAppNewsEntity entity, String content) {
		if (!insert) {
			entity.setImageUrl1("");
			entity.setImageUrl2("");
			entity.setImageUrl3("");
			entity.setImageUrl4("");
			entity.setImageUrl5("");
			entity.setImageUrl6("");
			entity.setImageUrl7("");
			entity.setImageUrl8("");
			entity.setImageUrl9("");
		}
		if (StringUtils.isNotBlank(content)) {
			content = content.replaceAll(filesServerRootUrl, "");
			entity.setContent(content);
			entity.setLinkUrl("");
			handleImages(entity, content);
			return content;
		}
		return null;
	}


	private void handleImages(SysAppNewsEntity entity, String content) {
		List<String> srcs = LKHtmlUtils.extractImgTag_src(content);
		if (CollectionUtils.isEmpty(srcs)) {
			return;
		}

		int i = 0;
		for (String src : srcs) {
			if (!src.startsWith("http")) {
				switch (i++) {
					case 0:
						entity.setImageUrl1(handleThumb(src));
						continue;
					case 1:
						entity.setImageUrl2(handleThumb(src));
						continue;
					case 2:
						entity.setImageUrl3(handleThumb(src));
						continue;
					case 3:
						entity.setImageUrl4(handleThumb(src));
						continue;
					case 4:
						entity.setImageUrl5(handleThumb(src));
						continue;
					case 5:
						entity.setImageUrl6(handleThumb(src));
						continue;
					case 6:
						entity.setImageUrl7(handleThumb(src));
						continue;
					case 7:
						entity.setImageUrl8(handleThumb(src));
						continue;
					case 8:
						entity.setImageUrl9(handleThumb(src));
						continue;
				}
				break;
			}
		}
	}


	/**
	 * 处理图片
	 * @param src 原图片地址
	 * @return 图片存放地址
	 */
	private String handleThumb(String src) {
		String thumb = src.substring(0, src.indexOf(".")) + "_thumb" + src.substring(src.indexOf("."));
		new Thread(() -> LKImageUtils.zoomImage(filesSaveRootPath + src, filesSaveRootPath + thumb, 512, 512)).start();
		return thumb;
	}

}
