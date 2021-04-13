package com.smb.population.exceptions;

public class PopulationException extends Exception {

	private static final long serialVersionUID = 7538093558817144957L;

	public PopulationException(String message, Throwable exception) {
		super(message, exception);
	}
	
	public PopulationException(Throwable exception) {
		super(exception);
	}
	
	public PopulationException(String message) {
		super(message);
	}
	
	public PopulationException() {
		super();
	}
}
