package com.smb.population.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.smb.population.dao.hibernate.CityDAOHibernate;
import com.smb.population.entities.City;
import com.smb.population.exceptions.ListObjectsException;
import com.smb.population.usecases.city.ListCities.ListCities;
import com.smb.population.usecases.city.ListCities.ListCitiesResponse;

@ManagedBean(name="cities")
@ViewScoped
public class Cities implements Serializable {

	private static final long serialVersionUID = -4191540964617432672L;
	
	List<City> list;

	@PostConstruct
	public void init() {				
		try {
			ListCitiesResponse response = new ListCities(new CityDAOHibernate()).execute();
			this.list = response.getCities();
		} catch (ListObjectsException e) {
			this.list = new ArrayList<City>();
		}				
	}

	/**
	 * @return the list
	 */
	public List<City> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<City> list) {
		this.list = list;
	}
}
