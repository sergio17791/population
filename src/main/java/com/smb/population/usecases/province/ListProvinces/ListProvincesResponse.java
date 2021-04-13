package com.smb.population.usecases.province.ListProvinces;

import java.util.List;

import com.smb.population.entities.Province;

public class ListProvincesResponse {

	List<Province> provinces;

	public ListProvincesResponse(List<Province> provinces) {
		this.provinces = provinces;
	}

	/**
	 * @return the provinces
	 */
	public List<Province> getProvinces() {
		return provinces;
	}	
}
