package com.smb.population.dao;

import java.io.Serializable;
import java.util.List;

import com.smb.population.exceptions.GetObjectException;
import com.smb.population.exceptions.ListObjectsException;

public interface BaseDAO<T, ID extends Serializable> {
	T get(ID id) throws GetObjectException;
	List<T> listAll() throws ListObjectsException;
}
