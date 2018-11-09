package com.lichkin.application;

import org.junit.Test;

import com.lichkin.springframework.generator.LKApiGenerator;
import com.lichkin.springframework.generator.LKApiGenerator.Type;

public class LKApiGeneratorRunner {

	String projectDir = Thread.currentThread().getContextClassLoader().getResource(".").getPath().replace("/target/test-classes/", "");

	String apiType = "WEB";

	String userType = "ADMIN";

	int index = 0;

	int errorCode = 40000;


	@Test
	public void generateInsert() {
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppVersionEntity", index, errorCode, Type.Insert, "新增数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppBannerEntity", index, errorCode, Type.Insert, "新增数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppNewsEntity", index, errorCode, Type.Insert, "新增数据接口");
	}


	@Test
	public void generateUpdate() {
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppVersionEntity", index, errorCode, Type.Update, "编辑数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppBannerEntity", index, errorCode, Type.Update, "编辑数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppNewsEntity", index, errorCode, Type.Update, "编辑数据接口");
	}


	@Test
	public void generateDelete() {
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppVersionEntity", index, errorCode, Type.Delete, "删除数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppBannerEntity", index, errorCode, Type.Delete, "删除数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppNewsEntity", index, errorCode, Type.Delete, "删除数据接口");
	}


	@Test
	public void generatePage() {
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppApiRequestLogEntity", index, errorCode, Type.GetPage, "获取分页数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppVersionEntity", index, errorCode, Type.GetPage, "获取分页数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppBannerEntity", index, errorCode, Type.GetPage, "获取分页数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppNewsEntity", index, errorCode, Type.GetPage, "获取分页数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppScoreEntity", index, errorCode, Type.GetPage, "获取分页数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppFeedbackEntity", index, errorCode, Type.GetPage, "获取分页数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppSignInLogEntity", index, errorCode, Type.GetPage, "获取分页数据接口");
	}


	@Test
	public void generateList() {
		LKApiGenerator.generate(userType, apiType, projectDir, "", index, errorCode, Type.GetList, "获取列表数据接口");
	}


	@Test
	public void generateOne() {
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppVersionEntity", index, errorCode, Type.GetOne, "获取单个数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppBannerEntity", index, errorCode, Type.GetOne, "获取单个数据接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppNewsEntity", index, errorCode, Type.GetOne, "获取单个数据接口");
	}


	@Test
	public void generateUS() {
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppVersionEntity", index, errorCode, Type.UpdateUsingStatus, "修改状态接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppBannerEntity", index, errorCode, Type.UpdateUsingStatus, "修改状态接口");
		LKApiGenerator.generate(userType, apiType, projectDir, "SysAppNewsEntity", index, errorCode, Type.UpdateUsingStatus, "修改状态接口");
	}

}
