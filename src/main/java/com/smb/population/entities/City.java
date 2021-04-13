package com.smb.population.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends BaseEntity {

	@ManyToOne
	@JoinColumn(name="province", nullable=false)
	private Province province;
	
	@Column(name = "population", nullable = false)
	private Integer population;
	
	public City() {
		super();
	}
	
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
