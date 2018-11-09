package com.lichkin.application.services.bus.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.defines.enums.impl.LKClientTypeEnum;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKDBService;

@Service
public class SysAppVersionBusService extends LKDBService {

	public List<SysAppVersionEntity> findExist(String id, String appKey, LKClientTypeEnum clientType, Byte versionX, Byte versionY, Short versionZ) {
		QuerySQL sqlObj = new QuerySQL(false, SysAppVersionEntity.class);

		if (StringUtils.isNotBlank(id)) {
			sqlObj.neq(SysAppVersionR.id, id);
		}

		sqlObj.eq(SysAppVersionR.appKey, appKey);
		sqlObj.eq(SysAppVersionR.clientType, clientType);
		sqlObj.eq(SysAppVersionR.versionX, versionX);
		sqlObj.eq(SysAppVersionR.versionY, versionY);
		sqlObj.eq(SysAppVersionR.versionZ, versionZ);
		return dao.getList(sqlObj, SysAppVersionEntity.class);
	}

}
