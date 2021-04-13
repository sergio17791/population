package com.smb.population.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province extends BaseEntity {
	
	@OneToMany(mappedBy="province")
	private List<City> cities;
	
	public Province() {
		
	}

	public Province(Integer id, String name, Date createdAt, Date updatedAt) {
		super(id, name, createdAt, updatedAt);
	}

	/**
	 * @return the cities
	 */
	public List<City> getCities() {
		return cities;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
