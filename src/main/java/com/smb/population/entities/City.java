package com.smb.population.entities;

import java.util.Date;

public class City extends BaseEntity {

	private Province province;
		
	private Integer population;
	
	public City(Integer id, String name, Province province, Integer population, Date createdAt, Date updatedAt) {
		super(id, name, createdAt, updatedAt);
		this.province = province;
		this.population = population;
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

	/**
	 * @return the population
	 */
	public Integer getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(Integer population) {
		this.population = population;
	}
}
