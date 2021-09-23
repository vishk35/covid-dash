package com.covid.dashboard.bean;

import java.util.List;
import java.util.Map;

public class Cases {

	private Map<Key, Case> casesByCountryCity;
	
	private Map<String, List<Case>> casesByCountry;
	
	private Map<Key, Case> casesByCountryAndDate;
	
	public Map<Key, Case> getCasesByCountryAndDate() {
		return casesByCountryAndDate;
	}

	public void setCasesByCountryAndDate(Map<Key, Case> casesByCountryAndDate) {
		this.casesByCountryAndDate = casesByCountryAndDate;
	}

	public Map<Key, Case> getCasesByCountryCity() {
		return casesByCountryCity;
	}

	public void setCasesByCountryCity(Map<Key, Case> casesByCountryCity) {
		this.casesByCountryCity = casesByCountryCity;
	}

	public Map<String, List<Case>> getCasesByCountry() {
		return casesByCountry;
	}

	public void setCasesByCountry(Map<String, List<Case>> casesByCountry) {
		this.casesByCountry = casesByCountry;
	}


}
