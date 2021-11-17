package com.voxsmart.test;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.voxsmart.test.service.ValidatePhoneFormat;
import com.voxsmart.test.service.CountryService;
import com.voxsmart.test.service.impl.ValidatePhoneFormatImpl;
import com.voxsmart.test.service.impl.countryServiceImpl;

public class NumberParser {

	private static String PLUS_SIGN = "+";
	
	Map<String, Integer> countryCodes;
	Map<String, String> nationalTrunkPrefixes;
	
	public NumberParser(Map<String, Integer> countryCodes, Map<String, String> nationalTrunkPrefixes) {
		this.countryCodes = countryCodes;
		this.nationalTrunkPrefixes = nationalTrunkPrefixes;
	}
	
	public String parse(String dialledNumber, String userNumber) {
		String parseDialNumber = "";
		//validate the dialNumber format
		ValidatePhoneFormat format= new ValidatePhoneFormatImpl();
		format.validate(dialledNumber, true);
		
		//Validate the userNumber format
		format.validate(userNumber, false);
		
		//find the country of the dialledNumber
		CountryService countryService = new countryServiceImpl();
		String country = countryService.getContryByNationalPhoneNumber(dialledNumber);
		
		Integer dialledNumberCountryCode = countryCodes.get(country);
		String dialledNumberNationalTrunkPrefixes = nationalTrunkPrefixes.get(country);
		
		if(StringUtils.isEmpty(dialledNumberNationalTrunkPrefixes)
				|| Integer.valueOf(dialledNumberNationalTrunkPrefixes)==1 ) {
			parseDialNumber = PLUS_SIGN + dialledNumberCountryCode + dialledNumber;
		}else {
			int len = dialledNumberNationalTrunkPrefixes.length();
			parseDialNumber =  PLUS_SIGN + dialledNumberCountryCode + dialledNumber.substring(len);
		}
		
		return parseDialNumber;
	}
}
