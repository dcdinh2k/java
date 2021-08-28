package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
	private String[] operatingSystems;
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOpearingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}



	public Student() {
		
		countryOptions = new LinkedHashMap<String, String>();
		
		countryOptions.put( "TH", "Thailand");
		countryOptions.put( "VN", "Viet Nam");
		countryOptions.put( "Lao", "Lao");
		countryOptions.put( "KHM", "Campuchia");
	}
	
	
	
	public Student(String firstName, String lastName, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
	}



	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}



	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}



	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	
	
	
}
