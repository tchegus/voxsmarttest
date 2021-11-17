package com.voxsmart.test.service.impl;

import java.util.Properties;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import com.voxsmart.test.exception.PhoneNumberValidationException;
import com.voxsmart.test.properties.ApplicationProperties;
import com.voxsmart.test.service.ValidatePhoneFormat;

public class ValidatePhoneFormatImpl implements ValidatePhoneFormat{

    //public static String INTERNATIONAL_PHONE_NUMBER_REGEX = "^+(?:[0-9] ?){6,14}[0-9]$";
	//public static String NATIONAL_PHONE_NUMBER_REGEX = "^(?:[0-9] ?){6,14}[0-9]$";
	
	public static String INTERNATIONAL_PHONE_NUMBER_REGEX = "phonenumber.international.regex";
	public static String NATIONAL_PHONE_NUMBER_REGEX = "phonenumber.national.regex";
	
	
	public void validate(String phoneNumber, boolean isNational) {
		Properties props = ApplicationProperties.getApplicationProperties();
		if(isNational) {
			validate(phoneNumber,props.getProperty(NATIONAL_PHONE_NUMBER_REGEX));
		}else {
			validate(phoneNumber, props.getProperty(INTERNATIONAL_PHONE_NUMBER_REGEX));
		}
	}
	
	private void validate(String phoneNumber, String regex) {
		try {
			phoneNumber.matches(regex);
		}catch(PatternSyntaxException e) {
		 throw new PhoneNumberValidationException("The format of the phone number is not valid ");	
		}
	}

}
