package com.smb.population.unit.usecases.province;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.smb.population.dao.ProvinceDAO;
import com.smb.population.entities.Province;
import com.smb.population.exceptions.PopulationException;
import com.smb.population.usecases.province.ListProvinces.ListProvinces;
import com.smb.population.usecases.province.ListProvinces.ListProvincesResponse;

public class ListProvincesTest {

	private ListProvinces listProvinces;
	
	private ProvinceDAO provinceDAO;
		
	@Before
	public void setUp() {
		this.provinceDAO = Mockito.mock(ProvinceDAO.class);
		this.listProvinces = new ListProvinces(provinceDAO);		
	}
	
	@Test(expected = PopulationException.class)
	public void test_execute_givenAnErrorWhenListProvinces_expectThrowPopulationException() throws PopulationException {
		
		Mockito.doThrow(PopulationException.class).when(provinceDAO).listAll();
		
		this.listProvinces.execute();
	}
	
	public void test_execute_givenThereIsNoData_expectEmptyList() throws PopulationException {
				
		Mockito.doReturn(new ArrayList<Province>()).when(provinceDAO).listAll();
		
		ListProvincesResponse response = this.listProvinces.execute();
		
		Assert.assertTrue(response.getProvinces().isEmpty());
	}
	
	public void test_execute_givenThereIsData_expectList() throws PopulationException {
				
		List<Province> provinces = new ArrayList<Province>();
		provinces.add(new Province());
		provinces.add(new Province());
		provinces.add(new Province());
		
		Mockito.doReturn(provinces).when(provinceDAO).listAll();
		
		ListProvincesResponse response = this.listProvinces.execute();
		
		Assert.assertFalse(response.getProvinces().isEmpty());
	}
}
