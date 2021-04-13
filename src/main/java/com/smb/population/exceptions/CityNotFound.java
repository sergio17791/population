package com.smb.population.exceptions;

public class CityNotFound extends PopulationException {

	private static final long serialVersionUID = 4882799952237346840L;
	
	public CityNotFound(String message) {
		super(message);
	}
}
