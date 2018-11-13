package com.lichkin.application.apis.GetBannerList;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lichkin.defines.AppStatics;
import com.lichkin.framework.beans.impl.Datas;
import com.lichkin.framework.db.beans.Condition;
import com.lichkin.framework.db.beans.Order;
import com.lichkin.framework.db.beans.QuerySQL;
import com.lichkin.framework.db.beans.SysAppBannerR;
import com.lichkin.framework.db.beans.eq;
import com.lichkin.framework.db.beans.like;
import com.lichkin.framework.db.enums.LikeType;
import com.lichkin.framework.defines.LKFrameworkStatics;
import com.lichkin.framework.defines.enums.impl.LKUsingStatusEnum;
import com.lichkin.framework.defines.exceptions.LKException;
import com.lichkin.framework.utils.LKListUtils;
import com.lichkin.springframework.entities.impl.SysAppBannerEntity;
import com.lichkin.springframework.services.LKApiService;
import com.lichkin.springframework.services.LKApiServiceImpl;

@Service(Statics.SERVICE_NAME)
public class S extends LKApiServiceImpl<I, List<O>> implements LKApiService<I, List<O>> {

	/** 文件服务器URL根路径 */
	@Value("${com.lichkin.files.server.rootUrl}")
	private String filesServerRootUrl;

	/** 接口服务器URL根路径 */
	@Value("${com.lichkin.apis.server.rootUrl}")
	private String apisServerRootUrl;


	@Override
	public List<O> handle(I sin, String locale, String compId, String loginId) throws LKException {
		return LKListUtils.convert(getListEntity(sin), source -> new O(filesServerRootUrl + source.getBanner(), apisServerRootUrl + AppStatics.PAGE_URL_APP_BANNER + source.getId(), source.getTitle()));
	}


	private List<SysAppBannerEntity> getListEntity(I sin) {
		Datas datas = sin.getDatas();

		QuerySQL sql = new QuerySQL(false, SysAppBannerEntity.class);

		sql.eq(SysAppBannerR.usingStatus, LKUsingStatusEnum.USING);
		sql.eq(SysAppBannerR.compId, datas.getCompId());
		sql.eq(SysAppBannerR.locale, datas.getLocale());
		sql.eq(SysAppBannerR.appKey, datas.getAppKey());
		sql.eq(SysAppBannerR.clientType, datas.getClientType());

		sql.where(

				new Condition(true,

						new Condition(null, new like(SysAppBannerR.versions, LikeType.ALL, String.format("%s%s.%s.%s%s", LKFrameworkStatics.SPLITOR, datas.getVersionX(), datas.getVersionY(), datas.getVersionZ(), LKFrameworkStatics.SPLITOR))),

						new Condition(false, new eq(SysAppBannerR.versions, ""))

				)

		);

		sql.addOrders(new Order(SysAppBannerR.orderId), new Order(SysAppBannerR.id));

		return dao.getList(sql, SysAppBannerEntity.class);
	}

}