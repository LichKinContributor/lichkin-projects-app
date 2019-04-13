package com.lichkin.application.apis.SignIn;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAccumulateR;
import com.lichkin.framework.db.beans.SysAppSignInLogR;
import com.lichkin.framework.defines.enums.LKCodeEnum;
import com.lichkin.framework.defines.enums.impl.LKDateTimeTypeEnum;
import com.lichkin.framework.utils.LKDateTimeUtils;
import com.lichkin.springframework.controllers.ApiKeyValues;
import com.lichkin.springframework.entities.impl.SysAccumulateEntity;
import com.lichkin.springframework.entities.impl.SysAccumulateFlowEntity;
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
	protected List<SysAppSignInLogEntity> findExist(I sin, ApiKeyValues<I> params) {
		QuerySQL sql = new QuerySQL(SysAppSignInLogEntity.class);

		sql.eq(SysAppSignInLogR.loginId, params.getLoginId());
		sql.eq(SysAppSignInLogR.signDate, LKDateTimeUtils.now(LKDateTimeTypeEnum.DATE_ONLY));

		return dao.getList(sql, SysAppSignInLogEntity.class);
	}


	@Override
	protected boolean forceCheck(I sin, ApiKeyValues<I> params) {
		return true;
	}


	@Override
	protected LKCodeEnum existErrorCode(I sin, ApiKeyValues<I> params) {
		return ErrorCodes.app_signed_in_today;
	}


	@Override
	protected void beforeSaveMain(I sin, ApiKeyValues<I> params, SysAppSignInLogEntity entity) {
		entity.setSignDate(LKDateTimeUtils.now(LKDateTimeTypeEnum.DATE_ONLY));
	}


	/** 签到积分 */
	@Value("${com.lichkin.apis.signin.accumulate:100}")
	private Integer signinAccumulate;


	@Override
	protected void afterSaveMain(I cin, ApiKeyValues<I> params, SysAppSignInLogEntity entity, String id) {
		if (signinAccumulate != 0) {
			QuerySQL sql = new QuerySQL(false, SysAccumulateEntity.class);
			sql.eq(SysAccumulateR.loginId, params.getLoginId());
			SysAccumulateEntity accumulate = dao.getOne(sql, SysAccumulateEntity.class);
			accumulate.setAppKey(cin.getDatas().getAppKey());
			accumulate.setAccumulate(accumulate.getAccumulate() + signinAccumulate);
			dao.mergeOne(accumulate);

			SysAccumulateFlowEntity accumulateFlow = new SysAccumulateFlowEntity();
			accumulateFlow.setAppKey(cin.getDatas().getAppKey());
			accumulateFlow.setLoginId(params.getLoginId());
			accumulateFlow.setIncrease(true);
			accumulateFlow.setAccumulate(signinAccumulate);
			accumulateFlow.setRemarks("签到");
			accumulateFlow.setInsertTime(LKDateTimeUtils.now());
			dao.persistOne(accumulateFlow);
		}
	}

}
