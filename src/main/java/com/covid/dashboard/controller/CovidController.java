package com.covid.dashboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.covid.dashboard.bean.Case;
import com.covid.dashboard.bean.Response;
import com.covid.dashboard.dao.CovidCasesDao;
import com.covid.dashboard.service.CovidCasesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CovidController {

	@Autowired
	private CovidCasesDao dao;
	@Autowired
	private CovidCasesService service;
	
	@GetMapping(value = "covid/cases")
	public Response findById(@RequestParam("query") String query) {
		ObjectMapper map = new ObjectMapper();
		try {
			Map<?, ?> queryData = map.readValue(query, Map.class);
			String type = (String) queryData.get("type");
			
			if(type.equalsIgnoreCase("country")) {
				return service.getCaseCountry(queryData);
			}else {
				return service.getCaseCountryCity(queryData);
			}
			 
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = "covid/cases/alldata")
	public Map<String, List<Case>> getAllData(@RequestParam("query") String query) {
		return dao.getData(null).getCasesByCountry();
	}

}
