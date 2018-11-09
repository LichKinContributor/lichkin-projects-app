package com.lichkin.framework.db.beans;

/**
 * 数据库资源初始化类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
class SysAppRInitializer implements LKRInitializer {

	/**
	 * 初始化数据库资源
	 */
	public static void init() {
		LKDBResource.addTable("com.lichkin.springframework.entities.impl.SysAppApiRequestLogEntity", "T_SYS_APP_API_REQUEST_LOG", "SysAppApiRequestLogEntity");
		LKDBResource.addColumn("60000000", "SysAppApiRequestLogEntity", "id");
		LKDBResource.addColumn("60000001", "SysAppApiRequestLogEntity", "usingStatus");
		LKDBResource.addColumn("60000002", "SysAppApiRequestLogEntity", "insertTime");
		LKDBResource.addColumn("60000003", "SysAppApiRequestLogEntity", "appKey");
		LKDBResource.addColumn("60000004", "SysAppApiRequestLogEntity", "clientType");
		LKDBResource.addColumn("60000005", "SysAppApiRequestLogEntity", "versionX");
		LKDBResource.addColumn("60000006", "SysAppApiRequestLogEntity", "versionY");
		LKDBResource.addColumn("60000007", "SysAppApiRequestLogEntity", "versionZ");
		LKDBResource.addColumn("60000008", "SysAppApiRequestLogEntity", "loginId");
		LKDBResource.addColumn("60000009", "SysAppApiRequestLogEntity", "locale");
		LKDBResource.addColumn("60000010", "SysAppApiRequestLogEntity", "osVersion");
		LKDBResource.addColumn("60000011", "SysAppApiRequestLogEntity", "brand");
		LKDBResource.addColumn("60000012", "SysAppApiRequestLogEntity", "model");
		LKDBResource.addColumn("60000013", "SysAppApiRequestLogEntity", "uuid");
		LKDBResource.addColumn("60000014", "SysAppApiRequestLogEntity", "screenWidth");
		LKDBResource.addColumn("60000015", "SysAppApiRequestLogEntity", "screenHeight");
		LKDBResource.addTable("com.lichkin.springframework.entities.impl.SysAppVersionEntity", "T_SYS_APP_VERSION", "SysAppVersionEntity");
		LKDBResource.addColumn("60001000", "SysAppVersionEntity", "id");
		LKDBResource.addColumn("60001001", "SysAppVersionEntity", "usingStatus");
		LKDBResource.addColumn("60001002", "SysAppVersionEntity", "insertTime");
		LKDBResource.addColumn("60001003", "SysAppVersionEntity", "appKey");
		LKDBResource.addColumn("60001004", "SysAppVersionEntity", "clientType");
		LKDBResource.addColumn("60001005", "SysAppVersionEntity", "versionX");
		LKDBResource.addColumn("60001006", "SysAppVersionEntity", "versionY");
		LKDBResource.addColumn("60001007", "SysAppVersionEntity", "versionZ");
		LKDBResource.addColumn("60001008", "SysAppVersionEntity", "forceUpdate");
		LKDBResource.addColumn("60001009", "SysAppVersionEntity", "tip");
		LKDBResource.addColumn("60001010", "SysAppVersionEntity", "url");
		LKDBResource.addColumn("60001011", "SysAppVersionEntity", "publishTime");
		LKDBResource.addTable("com.lichkin.springframework.entities.impl.SysAppBannerEntity", "T_SYS_APP_BANNER", "SysAppBannerEntity");
		LKDBResource.addColumn("60002000", "SysAppBannerEntity", "id");
		LKDBResource.addColumn("60002001", "SysAppBannerEntity", "usingStatus");
		LKDBResource.addColumn("60002002", "SysAppBannerEntity", "insertTime");
		LKDBResource.addColumn("60002003", "SysAppBannerEntity", "compId");
		LKDBResource.addColumn("60002004", "SysAppBannerEntity", "appKey");
		LKDBResource.addColumn("60002005", "SysAppBannerEntity", "clientType");
		LKDBResource.addColumn("60002006", "SysAppBannerEntity", "loginId");
		LKDBResource.addColumn("60002007", "SysAppBannerEntity", "locale");
		LKDBResource.addColumn("60002008", "SysAppBannerEntity", "versions");
		LKDBResource.addColumn("60002009", "SysAppBannerEntity", "categoryCode");
		LKDBResource.addColumn("60002010", "SysAppBannerEntity", "templateCode");
		LKDBResource.addColumn("60002011", "SysAppBannerEntity", "title");
		LKDBResource.addColumn("60002012", "SysAppBannerEntity", "brief");
		LKDBResource.addColumn("60002013", "SysAppBannerEntity", "keywords");
		LKDBResource.addColumn("60002014", "SysAppBannerEntity", "author");
		LKDBResource.addColumn("60002015", "SysAppBannerEntity", "content");
		LKDBResource.addColumn("60002016", "SysAppBannerEntity", "linkUrl");
		LKDBResource.addColumn("60002017", "SysAppBannerEntity", "orderId");
		LKDBResource.addColumn("60002018", "SysAppBannerEntity", "publishTime");
		LKDBResource.addColumn("60002019", "SysAppBannerEntity", "banner");
		LKDBResource.addTable("com.lichkin.springframework.entities.impl.SysAppNewsEntity", "T_SYS_APP_NEWS", "SysAppNewsEntity");
		LKDBResource.addColumn("60003000", "SysAppNewsEntity", "id");
		LKDBResource.addColumn("60003001", "SysAppNewsEntity", "usingStatus");
		LKDBResource.addColumn("60003002", "SysAppNewsEntity", "insertTime");
		LKDBResource.addColumn("60003003", "SysAppNewsEntity", "compId");
		LKDBResource.addColumn("60003004", "SysAppNewsEntity", "appKey");
		LKDBResource.addColumn("60003005", "SysAppNewsEntity", "clientType");
		LKDBResource.addColumn("60003006", "SysAppNewsEntity", "loginId");
		LKDBResource.addColumn("60003007", "SysAppNewsEntity", "locale");
		LKDBResource.addColumn("60003008", "SysAppNewsEntity", "versions");
		LKDBResource.addColumn("60003009", "SysAppNewsEntity", "categoryCode");
		LKDBResource.addColumn("60003010", "SysAppNewsEntity", "templateCode");
		LKDBResource.addColumn("60003011", "SysAppNewsEntity", "title");
		LKDBResource.addColumn("60003012", "SysAppNewsEntity", "brief");
		LKDBResource.addColumn("60003013", "SysAppNewsEntity", "keywords");
		LKDBResource.addColumn("60003014", "SysAppNewsEntity", "author");
		LKDBResource.addColumn("60003015", "SysAppNewsEntity", "content");
		LKDBResource.addColumn("60003016", "SysAppNewsEntity", "linkUrl");
		LKDBResource.addColumn("60003017", "SysAppNewsEntity", "orderId");
		LKDBResource.addColumn("60003018", "SysAppNewsEntity", "publishTime");
		LKDBResource.addColumn("60003019", "SysAppNewsEntity", "imageUrl1");
		LKDBResource.addColumn("60003020", "SysAppNewsEntity", "imageUrl2");
		LKDBResource.addColumn("60003021", "SysAppNewsEntity", "imageUrl3");
		LKDBResource.addColumn("60003022", "SysAppNewsEntity", "imageUrl4");
		LKDBResource.addColumn("60003023", "SysAppNewsEntity", "imageUrl5");
		LKDBResource.addColumn("60003024", "SysAppNewsEntity", "imageUrl6");
		LKDBResource.addColumn("60003025", "SysAppNewsEntity", "imageUrl7");
		LKDBResource.addColumn("60003026", "SysAppNewsEntity", "imageUrl8");
		LKDBResource.addColumn("60003027", "SysAppNewsEntity", "imageUrl9");
		LKDBResource.addTable("com.lichkin.springframework.entities.impl.SysAppScoreEntity", "T_SYS_APP_SCORE", "SysAppScoreEntity");
		LKDBResource.addColumn("60004000", "SysAppScoreEntity", "id");
		LKDBResource.addColumn("60004001", "SysAppScoreEntity", "usingStatus");
		LKDBResource.addColumn("60004002", "SysAppScoreEntity", "insertTime");
		LKDBResource.addColumn("60004003", "SysAppScoreEntity", "appKey");
		LKDBResource.addColumn("60004004", "SysAppScoreEntity", "clientType");
		LKDBResource.addColumn("60004005", "SysAppScoreEntity", "versionX");
		LKDBResource.addColumn("60004006", "SysAppScoreEntity", "versionY");
		LKDBResource.addColumn("60004007", "SysAppScoreEntity", "versionZ");
		LKDBResource.addColumn("60004008", "SysAppScoreEntity", "loginId");
		LKDBResource.addColumn("60004009", "SysAppScoreEntity", "locale");
		LKDBResource.addColumn("60004010", "SysAppScoreEntity", "title");
		LKDBResource.addColumn("60004011", "SysAppScoreEntity", "content");
		LKDBResource.addColumn("60004012", "SysAppScoreEntity", "score");
		LKDBResource.addTable("com.lichkin.springframework.entities.impl.SysAppFeedbackEntity", "T_SYS_APP_FEEDBACK", "SysAppFeedbackEntity");
		LKDBResource.addColumn("60005000", "SysAppFeedbackEntity", "id");
		LKDBResource.addColumn("60005001", "SysAppFeedbackEntity", "usingStatus");
		LKDBResource.addColumn("60005002", "SysAppFeedbackEntity", "insertTime");
		LKDBResource.addColumn("60005003", "SysAppFeedbackEntity", "appKey");
		LKDBResource.addColumn("60005004", "SysAppFeedbackEntity", "clientType");
		LKDBResource.addColumn("60005005", "SysAppFeedbackEntity", "versionX");
		LKDBResource.addColumn("60005006", "SysAppFeedbackEntity", "versionY");
		LKDBResource.addColumn("60005007", "SysAppFeedbackEntity", "versionZ");
		LKDBResource.addColumn("60005008", "SysAppFeedbackEntity", "loginId");
		LKDBResource.addColumn("60005009", "SysAppFeedbackEntity", "locale");
		LKDBResource.addColumn("60005010", "SysAppFeedbackEntity", "content");
		LKDBResource.addColumn("60005011", "SysAppFeedbackEntity", "img");
		LKDBResource.addTable("com.lichkin.springframework.entities.impl.SysAppSignInLogEntity", "T_SYS_APP_SIGN_IN_LOG", "SysAppSignInLogEntity");
		LKDBResource.addColumn("60006000", "SysAppSignInLogEntity", "id");
		LKDBResource.addColumn("60006001", "SysAppSignInLogEntity", "usingStatus");
		LKDBResource.addColumn("60006002", "SysAppSignInLogEntity", "insertTime");
		LKDBResource.addColumn("60006003", "SysAppSignInLogEntity", "appKey");
		LKDBResource.addColumn("60006004", "SysAppSignInLogEntity", "clientType");
		LKDBResource.addColumn("60006005", "SysAppSignInLogEntity", "versionX");
		LKDBResource.addColumn("60006006", "SysAppSignInLogEntity", "versionY");
		LKDBResource.addColumn("60006007", "SysAppSignInLogEntity", "versionZ");
		LKDBResource.addColumn("60006008", "SysAppSignInLogEntity", "loginId");
		LKDBResource.addColumn("60006009", "SysAppSignInLogEntity", "locale");
		LKDBResource.addColumn("60006010", "SysAppSignInLogEntity", "signDate");
	}

}