package com.smb.population.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province extends BaseEntity {
	
	public Province() {
		
	}

	public Province(Integer id, String name, Date createdAt, Date updatedAt) {
		super(id, name, createdAt, updatedAt);
	}
}
