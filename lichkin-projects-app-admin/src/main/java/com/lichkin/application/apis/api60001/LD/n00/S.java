package com.lichkin.application.apis.api60001.LD.n00;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.lichkin.application.utils.LKDictUtils;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.db.beans.SysDictionaryR;
import com.lichkin.framework.defines.beans.impl.LKDroplistBean;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusGetDroplistService;

@Service("SysAppVersionLD00Service")
public class S extends LKApiBusGetDroplistService<I> {

	@Override
	public List<LKDroplistBean> handle(I sin, String locale, String compId, String loginId) throws LKException {
		String appKey = sin.getAppKey();

		if (StringUtils.isBlank(appKey)) {
			return Collections.emptyList();
		}

		QuerySQL sql = new QuerySQL(SysAppVersionEntity.class, true);

		sql.select(SysDictionaryR.dictCode, "value");
		sql.select(SysDictionaryR.dictName, "text");

		// 字典表
		int i = 0;
		LKDictUtils.clientType(sql, SysAppVersionR.clientType, i++);

		sql.eq(SysAppVersionR.usingStatus, LKUsingStatusEnum.USING);
		sql.eq(SysAppVersionR.appKey, appKey);

		return dao.getList(sql, LKDroplistBean.class);
	}

}
