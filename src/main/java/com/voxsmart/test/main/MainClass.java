package com.voxsmart.test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.voxsmart.test.NumberParser;

/**
 * This is the Main Class that allow to test app use some sample data. Please
 * refer to @see CountryService to know the national phone numbers which can
 * potentially work.
 * 
 * @author tcheg
 *
 */
public class MainClass {

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

	public static void main(String[] args) {

		// Map<String, Integer> countryCodes = new HashMap<String, Integer>();
		// Map<String, String> nationalTrunkPrefixes = new HashMap<String, String>();
		NumberParser parser = new NumberParser(countryCodes, nationalTrunkPrefixes);
		String dialledNumber;
		String userNumber;
		Scanner sc = new Scanner(System.in);
		String response;
		System.out.println("***************************************************");
		System.out.println("********** WELCOME IN THE DIAL APP ****************");
		System.out.println("***************************************************");

		while (true) {
			System.out.println("Do you want to perform a new test Y/N : ");
			response = sc.nextLine();
			if (!"Y".equalsIgnoreCase(response)) {
				break;
			} else {
				System.out.println("Enter the dialled Number : ");
				dialledNumber = sc.nextLine();
				System.out.println("Enter the userNumber : ");
				userNumber = sc.nextLine();
				try {
					String calledNumber = parser.parse(dialledNumber, userNumber);
					System.out.println("The calledNumber is : " + calledNumber + "\n");
				} catch (Exception e) {
					System.out.println(e.getMessage() +  "\n");
				}
			}
		}

		System.out.println("***************************************************");
		System.out.println("****************** GOOD BYE ***********************");
		System.out.println("***************************************************");
	}
}
