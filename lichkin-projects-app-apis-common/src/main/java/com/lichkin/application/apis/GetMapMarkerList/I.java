package com.lichkin.application.apis.GetMapMarkerList;

import com.lichkin.framework.beans.impl.LKRequestBean;
import com.lichkin.framework.defines.enums.impl.LKMapAPIEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class I extends LKRequestBean {

	/** 地图类型 */
	private LKMapAPIEnum mapType;

	/** 查询圆心纬度 */
	private double latitude;

	/** 查询圆心经度 */
	private double longitude;

	/** 查询关键字 */
	private String key;

	/** 查询半径 */
	private int radius;

}
