package com.smb.population.unit.usecases.province;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.smb.population.dao.ProvinceDAO;
import com.smb.population.entities.Province;
import com.smb.population.exceptions.GetObjectException;
import com.smb.population.exceptions.PopulationException;
import com.smb.population.exceptions.ProvinceNotFound;
import com.smb.population.usecases.province.GetProvince.GetProvince;
import com.smb.population.usecases.province.GetProvince.GetProvinceRequest;
import com.smb.population.usecases.province.GetProvince.GetProvinceResponse;

public class GetProvinceTest {

	private GetProvince getProvince;
	
	private ProvinceDAO provinceDAO;
		
	@Before
	public void setUp() {
		this.provinceDAO = Mockito.mock(ProvinceDAO.class);
		this.getProvince = new GetProvince(provinceDAO);		
	}
	
	@Test(expected = GetObjectException.class)
	public void test_execute_givenAnErrorWhenListProvinces_expectThrowPopulationException() throws PopulationException {
		
		Integer id = 1;
		
		Mockito.doThrow(GetObjectException.class).when(provinceDAO).get(id);
		
		GetProvinceRequest request = new GetProvinceRequest(id);
		
		this.getProvince.execute(request);
	}
	
	@Test(expected = ProvinceNotFound.class)
	public void test_execute_givenNonExistentID_expectThrowProvinceNotFound() throws PopulationException {
								
		Integer id = 1;
		
		Mockito.doReturn(null).when(provinceDAO).listAll();
		
		GetProvinceRequest request = new GetProvinceRequest(id);
		
		this.getProvince.execute(request);
	}
	
	public void test_execute_givenThereIsData_expectList() throws PopulationException {
				
		Integer id = 1;
		
		Province province = new Province(
				id,
				"Castellón/Castelló",
				new Date(),
				new Date()
		);
		
		Mockito.doReturn(province).when(provinceDAO).listAll();
		
		GetProvinceRequest request = new GetProvinceRequest(id);
		
		GetProvinceResponse useCaseResponse = this.getProvince.execute(request);
		Province response = useCaseResponse.getProvince();
		
		Assert.assertEquals(response.getId(), request.getId());
	}
}
