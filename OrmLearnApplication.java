package com.cognizant.ormlearn;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

	
	private static CountryService countryService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);

		 //testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		LOGGER.info("Inside main");
	}
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries = new ArrayList<Country>();
				countries=countryService.getAllCountries();
				for(Country c:countries) {
					System.out.println(c.getName());
				}
		

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		}
	private static void getAllCountriesTest() {

		LOGGER.info("Start");
        try {
		Country country = countryService.findCountryByCode("IN");
		System.out.println(country.getName());
       
		LOGGER.debug("Country:{}", country);
        }
		 catch(Exception e) {
	        	System.out.println(e);
	        }

		LOGGER.info("End");

		}
	private static void testAddCountry() {
		LOGGER.info("Start");
		Country c=new Country();
		c.setCode("CP");
		c.setName("caunaght palace");
		 countryService.addCountry(c);
		 try {
				Country country = countryService.findCountryByCode("CP");
				System.out.println(country.getName());
		       
				LOGGER.debug("Country:{}", country);
		        }
				 catch(Exception e) {
			        	System.out.println(e);
			        }
		 LOGGER.info("End");
}
	private static void testUpdateCountry() {
		LOGGER.info("Start");
        try {
		countryService.updateCountry("CP","New Country");
		Country country = countryService.findCountryByCode("CP");
		System.out.println(country.getName());
       
		LOGGER.debug("Country:{}", country);
        }
		 catch(Exception e) {
	        	System.out.println(e);
	        }

		LOGGER.info("End");

}
	private static void testDeleteCountry() {
		countryService.deleteCountry("CP");
 }
}