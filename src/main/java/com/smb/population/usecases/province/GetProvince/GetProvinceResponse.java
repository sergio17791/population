package com.smb.population.usecases.province.GetProvince;

import com.smb.population.entities.Province;

public class GetProvinceResponse {

	private Province province;

	public GetProvinceResponse(Province province) {
		this.province = province;
	}

	/**
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}
}
