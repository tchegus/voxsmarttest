package com.voxsmart.test.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.voxsmart.test.exception.NumberUnknownException;
import com.voxsmart.test.service.CountryService;

/**
 * We made the assumption that we have a service which is capable of providing the country for 
 * a given national phone number. We can thing about this class as a service which can connnect 
 * to a database which contains those information
 * 
 * For the purspose of this test we just use @java.util.Map to simulate that.
 * 
 * @author tcheg
 *
 */
public class countryServiceImpl implements CountryService{

	private static final Map<String, String> countryPhoneNumber = new HashMap<String,String>();
	
	static {
		countryPhoneNumber.put("07833733777","GB"); 
		countryPhoneNumber.put("07277822334","GB");
		countryPhoneNumber.put("07866866886","GB"); 
		countryPhoneNumber.put("0149527154","FR");
		countryPhoneNumber.put("1212233200","US");
		countryPhoneNumber.put("1312233244","US");
		countryPhoneNumber.put("1212233200","US");
		countryPhoneNumber.put("25218121","HK");
	}
	
	/**
	 * For a given phone number, this method return the country from which this number belong to.
	 */
	public String getContryByNationalPhoneNumber(String nationalPhoneNumner) {
		
		if(!countryPhoneNumber.containsKey(nationalPhoneNumner)) {
			throw new NumberUnknownException("The number provided is invalid or unknown. Please provid a valid one ");
		}
		return countryPhoneNumber.get(nationalPhoneNumner);
	}

}
