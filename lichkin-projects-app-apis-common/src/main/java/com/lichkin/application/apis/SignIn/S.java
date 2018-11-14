package com.lichkin.application.apis.SignIn;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppSignInLogR;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;
import com.lichkin.framework.utils.LKBeanUtils;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.springframework.entities.impl.SysAppSignInLogEntity;
import com.lichkin.springframework.services.LKApiBusInsertService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiBusInsertService<I, SysAppSignInLogEntity> {

	@Getter
	@RequiredArgsConstructor
	enum ErrorCodes implements LKCodeEnum {

		app_signed_in_today(40001),

		;

		private final Integer code;

	}


	@Override
	protected List<SysAppSignInLogEntity> findExist(I sin, String locale, String compId, String loginId) {
		QuerySQL sql = new QuerySQL(SysAppSignInLogEntity.class);

		sql.eq(SysAppSignInLogR.loginId, loginId);
		sql.eq(SysAppSignInLogR.signDate, LKDateTimeUtils.now(LKDateTimeTypeEnum.DATE_ONLY));

		return dao.getList(sql, SysAppSignInLogEntity.class);
	}


	@Override
	protected boolean forceCheck(I sin, String locale, String compId, String loginId) {
		return true;
	}


	@Override
	protected LKCodeEnum existErrorCode(I sin, String locale, String compId, String loginId) {
		return ErrorCodes.app_signed_in_today;
	}


	@Override
	protected void beforeSaveMain(I sin, String locale, String compId, String loginId, SysAppSignInLogEntity entity) {
		LKBeanUtils.copyProperties(sin.getDatas(), entity);
		entity.setAppKey(sin.getDatas().getAppKey());
		entity.setSignDate(LKDateTimeUtils.now(LKDateTimeTypeEnum.DATE_ONLY));
	}

}
