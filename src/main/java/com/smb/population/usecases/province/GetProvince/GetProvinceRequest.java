package com.smb.population.usecases.province.GetProvince;

public class GetProvinceRequest {

	private Integer id;

	public GetProvinceRequest(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
}
