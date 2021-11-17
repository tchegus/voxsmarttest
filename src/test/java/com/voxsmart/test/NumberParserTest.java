package com.voxsmart.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.voxsmart.test.exception.NumberUnknownException;

public class NumberParserTest {
	
	
	private static final String NO_COUNTRY_PREFIX = "";
	private static final Map<String, Integer> countryCodes = new HashMap<String, Integer>();
	private static final Map<String, String> nationalTrunkPrefixes = new HashMap<String, String>();
	
	static {
		countryCodes.put("GB", 44);
		countryCodes.put("US", 1);
		countryCodes.put("FR", 33);
		countryCodes.put("HK", 852);
		
		nationalTrunkPrefixes.put("GB", "0");
		nationalTrunkPrefixes.put("US", "0");
		nationalTrunkPrefixes.put("FR", "1");
		nationalTrunkPrefixes.put("HK", NO_COUNTRY_PREFIX);
	}
	
	NumberParser parse;
	
	@Before
	public void setUp() throws Exception {
		parse = new NumberParser(countryCodes, nationalTrunkPrefixes);
	}
	
	@Test
	public void parsePhoneNumberSucceeded() {
		String dialledNumber = "07277822334";
		String userNumber = "+447866866886";
		
		String expected = "+447277822334";
		String actual = parse.parse(dialledNumber, userNumber);
		assertEquals(expected, actual);
	}
	
	@Test
	public void parsePhoneNumberFailedForUnknownPhoneNumber() {
		String dialledNumber = "0727AA822334";
		String userNumber = "+447866866886";
        try {
        	parse.parse(dialledNumber, userNumber);
        }catch(Exception e) {
        	assertTrue(e instanceof NumberUnknownException);
        }
		
		
	}

}
