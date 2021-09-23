package com.covid.dashboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dashboard.bean.Case;
import com.covid.dashboard.bean.Cases;
import com.covid.dashboard.bean.Key;
import com.covid.dashboard.bean.Response;

@Service
public class CovidCasesService {

	@Autowired
	private Cases cases;

	public Response getCaseCountry(Map<?, ?> queryData) {

		String country = (String) queryData.get("country");
		Response resp = new Response();
		resp.setCases(cases.getCasesByCountry().get(country.toUpperCase()));
		return resp;

	}

	public Response getCaseCountryCity(Map<?, ?> queryData) {

		String country = (String) queryData.get("country");
		String city = (String) queryData.get("city");
		Key key = new Key();
		key.setCountryRegion(country);
		key.setProvinceState(city);
		
		Response resp = new Response();
		List<Case> case1 = new ArrayList<>();
		case1.add(cases.getCasesByCountryCity().get(key));
		
		resp.setCases(case1);
		return resp;
	}

}
