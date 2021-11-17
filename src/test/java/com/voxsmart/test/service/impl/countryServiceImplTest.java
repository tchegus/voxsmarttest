package com.voxsmart.test.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.voxsmart.test.exception.NumberUnknownException;
import com.voxsmart.test.service.CountryService;

public class countryServiceImplTest {

	CountryService countryService;
	@Before
	public void setUp() throws Exception {
		countryService = new countryServiceImpl();
	}

	@Test
	public void testValideNationalPhoneNumber() {
		String nationalPhoneNumner = "07277822334";
		String expected = "GB";
		String actual = countryService.getContryByNationalPhoneNumber(nationalPhoneNumner);
		assertEquals(expected, actual);
	}
	
	@Test(expected = NumberUnknownException.class)
	public void testInValideNationalPhoneNumber() {
		String nationalPhoneNumner = "0727782AA334";
		countryService.getContryByNationalPhoneNumber(nationalPhoneNumner);
	}

}
