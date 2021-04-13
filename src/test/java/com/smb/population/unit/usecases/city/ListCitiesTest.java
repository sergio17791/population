package com.smb.population.unit.usecases.city;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.smb.population.dao.CityDAO;
import com.smb.population.entities.City;
import com.smb.population.exceptions.ListObjectsException;
import com.smb.population.exceptions.PopulationException;
import com.smb.population.usecases.city.ListCities.ListCities;
import com.smb.population.usecases.city.ListCities.ListCitiesResponse;

public class ListCitiesTest {

	private ListCities listCities;
	
	private CityDAO cityDAO;
		
	@Before
	public void setUp() {
		this.cityDAO = Mockito.mock(CityDAO.class);
		this.listCities = new ListCities(cityDAO);		
	}
	
	@Test(expected = ListObjectsException.class)
	public void test_execute_givenAnErrorWhenListCities_expectThrowPopulationException() throws PopulationException {
		
		Mockito.doThrow(ListObjectsException.class).when(cityDAO).listAll();
		
		this.listCities.execute();
	}
	
	public void test_execute_givenThereIsNoData_expectEmptyList() throws PopulationException {
				
		Mockito.doReturn(new ArrayList<City>()).when(cityDAO).listAll();
		
		ListCitiesResponse response = this.listCities.execute();
		
		Assert.assertTrue(response.getCities().isEmpty());
	}
	
	public void test_execute_givenThereIsData_expectList() throws PopulationException {
				
		List<City> cities = new ArrayList<City>();
		cities.add(new City());
		cities.add(new City());
		cities.add(new City());
		
		Mockito.doReturn(cities).when(cityDAO).listAll();
		
		ListCitiesResponse response = this.listCities.execute();
		
		Assert.assertFalse(response.getCities().isEmpty());
	}
}
