package com.lichkin.application.apis.GetMapMarkerList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class O {

	/** 主键 */
	private String id;

	/** 名字 */
	private String name;

	/** 纬度 */
	private double latitude;

	/** 经度 */
	private double longitude;

	/** 距离 */
	private int distance;

}
