package com.smb.population.entities;

import java.util.Date;
import java.util.UUID;

public class Province extends BaseEntity {

	public Province(UUID id, String name, Date createdAt, Date updatedAt) {
		super(id, name, createdAt, updatedAt);
	}
}
