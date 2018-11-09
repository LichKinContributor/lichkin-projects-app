package com.lichkin.application.utils;

import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.defines.LKFrameworkStatics;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 字典工具类
 * @author SuZhou LichKin Information Technology Co., Ltd.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LKDictUtils4App extends LKDictUtils {

	/**
	* 连接字典表（客户端版本状态）
	 * @param sql SQL语句对象
	 * @param columnResId 列资源ID
	 * @param tableIdx 字典表序号（从0开始）
	 */
	public static void appVersionUsingStatus(QuerySQL sql, int columnResId, int tableIdx) {
		leftJoinDictionary(sql, "usingStatus", LKFrameworkStatics.LichKin, "APP_VERSION_USING_STATUS", columnResId, tableIdx);
	}


	/**
	* 连接字典表（新闻状态）
	 * @param sql SQL语句对象
	 * @param columnResId 列资源ID
	 * @param tableIdx 字典表序号（从0开始）
	 */
	public static void newsUsingStatus(QuerySQL sql, int columnResId, int tableIdx) {
		leftJoinDictionary(sql, "usingStatus", LKFrameworkStatics.LichKin, "NEWS_USING_STATUS", columnResId, tableIdx);
	}


	/**
	* 连接字典表（客户端唯一标识）
	 * @param sql SQL语句对象
	 * @param compId 公司ID
	 * @param columnResId 列资源ID
	 * @param tableIdx 字典表序号（从0开始）
	 */
	public static void appKey(QuerySQL sql, String compId, int columnResId, int tableIdx) {
		leftJoinDictionary(sql, "appKey", compId, "APP_KEY", columnResId, tableIdx);
	}


	/**
	* 连接字典表（分类编码）
	 * @param sql SQL语句对象
	 * @param compId 公司ID
	 * @param columnResId 列资源ID
	 * @param tableIdx 字典表序号（从0开始）
	 */
	public static void newsCategory(QuerySQL sql, String compId, int columnResId, int tableIdx) {
		leftJoinDictionary(sql, "categoryCode", compId, "NEWS_CATEGORY", columnResId, tableIdx);
	}


	/**
	* 连接字典表（模板编码）
	 * @param sql SQL语句对象
	 * @param columnResId 列资源ID
	 * @param tableIdx 字典表序号（从0开始）
	 */
	public static void newsTemplate(QuerySQL sql, int columnResId, int tableIdx) {
		leftJoinDictionary(sql, "templateCode", LKFrameworkStatics.LichKin, "NEWS_TEMPLATE", columnResId, tableIdx);
	}

}
