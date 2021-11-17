package com.voxsmart.test.service;

import com.voxsmart.test.exception.NumberUnknownException;

public interface CountryService {

	String getContryByNationalPhoneNumber(String nationalPhoneNumner) throws NumberUnknownException;
}
