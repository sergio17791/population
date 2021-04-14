package com.smb.population.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.smb.population.dao.hibernate.ProvinceDAOHibernate;
import com.smb.population.entities.Province;
import com.smb.population.exceptions.GetObjectException;
import com.smb.population.exceptions.ProvinceNotFound;
import com.smb.population.usecases.province.GetProvince.GetProvince;
import com.smb.population.usecases.province.GetProvince.GetProvinceRequest;
import com.smb.population.usecases.province.GetProvince.GetProvinceResponse;

@ManagedBean(name="provinceDetail")
@ViewScoped
public class ProvinceDetail implements Serializable {

	private static final long serialVersionUID = -9017565912215784883L;

	private Integer id;
	
	Province province;
	
	public String load() {
		
		if (!FacesContext.getCurrentInstance().isPostback()) { 
			
			if(this.id == null) {
				return "provinces";
			}
			
			try {
				GetProvinceResponse response = new GetProvince(new ProvinceDAOHibernate()).execute(
						new GetProvinceRequest(id)
				);
					
				this.province = response.getProvince();		
				
			} catch (GetObjectException | ProvinceNotFound e) {
				return "provinces";
			}			
		}
		
		return null;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the province
	 */
	public Province getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(Province province) {
		this.province = province;
	}
}
