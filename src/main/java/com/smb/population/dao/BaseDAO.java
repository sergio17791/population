package com.smb.population.dao;

import java.io.Serializable;
import java.util.List;

import com.smb.population.exceptions.PopulationException;

public interface BaseDAO<T, ID extends Serializable> {
	T get(ID id) throws PopulationException;
	List<T> listAll() throws PopulationException;
}
