package com.smb.population.usecases.city.ListCities;

import java.util.List;

import com.smb.population.dao.CityDAO;
import com.smb.population.entities.City;
import com.smb.population.exceptions.ListObjectsException;

public class ListCities {

	private CityDAO cityDAO;

	public ListCities(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}
	
	public ListCitiesResponse execute() throws ListObjectsException {
		
		List<City> cities = this.cityDAO.listAll();
		
		return new ListCitiesResponse(cities);
	}
}
