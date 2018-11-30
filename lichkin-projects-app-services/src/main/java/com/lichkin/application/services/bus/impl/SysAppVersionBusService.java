package com.lichkin.application.services.bus.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKDBService;

@Service
public class SysAppVersionBusService extends LKDBService {

	public List<SysAppVersionEntity> findExist(ApiKeyValues<?> params, String appKey, LKClientTypeEnum clientType, Byte versionX, Byte versionY, Short versionZ) {
		QuerySQL sql = new QuerySQL(false, SysAppVersionEntity.class);

		addConditionId(sql, SysAppVersionR.id, params.getId());
//		addConditionLocale(sql, SysAppVersionR.locale, params.getLocale());
//		addConditionCompId(true, sql, SysAppVersionR.compId, params.getCompId(), params.getBusCompId());
		addConditionUsingStatus(true, params.getCompId(), sql, SysAppVersionR.usingStatus, params.getUsingStatus(), LKUsingStatusEnum.USING);

		sql.eq(SysAppVersionR.appKey, appKey);
		sql.eq(SysAppVersionR.clientType, clientType);
		sql.eq(SysAppVersionR.versionX, versionX);
		sql.eq(SysAppVersionR.versionY, versionY);
		sql.eq(SysAppVersionR.versionZ, versionZ);
		return dao.getList(sql, SysAppVersionEntity.class);
	}

}
