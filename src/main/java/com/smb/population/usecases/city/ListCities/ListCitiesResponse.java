package com.smb.population.usecases.city.ListCities;

import java.util.List;

import com.smb.population.entities.City;

public class ListCitiesResponse {

	List<City> cities;

	public ListCitiesResponse(List<City> cities) {
		this.cities = cities;
	}

	/**
	 * @return the cities
	 */
	public List<City> getCities() {
		return cities;
	}	
}
