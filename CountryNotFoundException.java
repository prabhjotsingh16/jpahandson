package com.cognizant.ormlearn.service.exception;

public class CountryNotFoundException extends Exception {
	public CountryNotFoundException() {
        super("Country does not exist");
    }
}