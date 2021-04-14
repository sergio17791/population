package com.smb.population.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.smb.population.dao.hibernate.ProvinceDAOHibernate;
import com.smb.population.entities.Province;
import com.smb.population.exceptions.ListObjectsException;
import com.smb.population.usecases.province.ListProvinces.ListProvinces;
import com.smb.population.usecases.province.ListProvinces.ListProvincesResponse;

@ManagedBean(name="provinces")
@ViewScoped
public class Provinces implements Serializable {

	private static final long serialVersionUID = -4191540964617432672L;
	
	List<Province> list;

	@PostConstruct
	public void init() {				
		try {
			ListProvincesResponse response = new ListProvinces(new ProvinceDAOHibernate()).execute();
			this.list = response.getProvinces();
		} catch (ListObjectsException e) {
			this.list = new ArrayList<Province>();
		}				
	}

	/**
	 * @return the list
	 */
	public List<Province> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Province> list) {
		this.list = list;
	}
}
