package com.smb.population.usecases.province.GetProvince;

import com.smb.population.dao.ProvinceDAO;
import com.smb.population.entities.Province;
import com.smb.population.exceptions.GetObjectException;
import com.smb.population.exceptions.ProvinceNotFound;

public class GetProvince {

	private ProvinceDAO provinceDAO;

	public GetProvince(ProvinceDAO provinceDAO) {
		this.provinceDAO = provinceDAO;
	}
	
	public GetProvinceResponse execute(GetProvinceRequest request) throws GetObjectException, ProvinceNotFound {
		
		Integer id = request.getId();
		
		Province province = this.provinceDAO.get(id);
		
		if(province == null) {
			throw new ProvinceNotFound("Province with id " + id + " not found");
		}
		
		return new GetProvinceResponse(province);
	}
}
