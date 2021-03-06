package com.smb.population.usecases.province.ListProvinces;

import java.util.List;

import com.smb.population.dao.ProvinceDAO;
import com.smb.population.entities.Province;
import com.smb.population.exceptions.ListObjectsException;

public class ListProvinces {
	
	private ProvinceDAO provinceDAO;

	public ListProvinces(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}
	
	public ListProvincesResponse execute() throws ListObjectsException {
		
		List<Province> provinces = this.provinceDAO.listAll();
		
		return new ListProvincesResponse(provinces);
	}
}
