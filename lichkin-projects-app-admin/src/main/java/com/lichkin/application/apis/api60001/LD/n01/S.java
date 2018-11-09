package com.lichkin.application.apis.api60001.LD.n01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppVersionR;
import com.lichkin.framework.defines.beans.impl.LKDroplistBean;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.springframework.entities.impl.SysAppVersionEntity;
import com.lichkin.springframework.services.LKApiBusGetDroplistService;

@Service("SysAppVersionLD01Service")
public class S extends LKApiBusGetDroplistService<I> {

	@Override
	public List<LKDroplistBean> handle(I sin, String locale, String compId, String loginId) throws LKException {
		if (StringUtils.isBlank(sin.getAppKey()) || (sin.getClientType() == null)) {
			return Collections.emptyList();
		}

		QuerySQL sql = new QuerySQL(false, SysAppVersionEntity.class);

		sql.eq(SysAppVersionR.usingStatus, LKUsingStatusEnum.USING);
		sql.eq(SysAppVersionR.appKey, sin.getAppKey());
		sql.eq(SysAppVersionR.clientType, sin.getClientType());

		List<SysAppVersionEntity> list = dao.getList(sql, SysAppVersionEntity.class);
		if (CollectionUtils.isEmpty(list)) {
			return Collections.emptyList();
		}

		List<LKDroplistBean> out = new ArrayList<>(list.size());
		for (SysAppVersionEntity entity : list) {
			String text = entity.getVersionX().toString() + '.' + entity.getVersionY() + '.' + entity.getVersionZ();
			out.add(new LKDroplistBean(text, text));
		}
		return out;
	}

}
