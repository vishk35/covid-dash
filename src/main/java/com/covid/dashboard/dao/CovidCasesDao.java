package com.covid.dashboard.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.covid.dashboard.bean.Case;
import com.covid.dashboard.bean.Cases;
import com.covid.dashboard.bean.Key;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Repository	
public class CovidCasesDao {

	@Value("${gitrepo}")
	private String gitRepo;
	
	public Cases getData(Date date) {
		java.net.URL url = null;
		SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
		String stringDate = DateFor.format(date == null ? new Date() : date);
		System.out.println(stringDate);
		try {
			url = new java.net.URL(gitRepo + "01-01-2021" + ".csv");
			java.net.URLConnection uc;
			uc = url.openConnection();
			uc.setRequestProperty("X-Requested-With", "Curl");
			BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			CsvSchema casesSchema = CsvSchema.emptySchema().withHeader();
			CsvMapper csvMapper = new CsvMapper();
			MappingIterator<Case> cases = csvMapper.readerFor(Case.class).with(casesSchema).readValues(reader);
			List<Case> map = cases.readAll();
			Map<Key, Case> mapsByCountryAndRegion = new HashMap<>();
			Map<String, List<Case>> mapsByCountry = new HashMap<>();
			for (Case covidCase : map) {
				Key key = new Key();
				key.setCountryRegion(covidCase.getCountryRegion());
//				key.setLastUpdate(covidCase.getLastUpdate());
				key.setProvinceState(covidCase.getProvinceState());
				mapsByCountryAndRegion.put(key, covidCase);
				if(mapsByCountry.get(covidCase.getCountryRegion().toUpperCase())==null) {
					List<Case> lists = new ArrayList<>();
					lists.add(covidCase);
					mapsByCountry.put(covidCase.getCountryRegion().toUpperCase(), lists);
				}else {
					mapsByCountry.get(covidCase.getCountryRegion().toUpperCase()).add(covidCase);
				}
			}
			Cases allCases = new Cases();
			allCases.setCasesByCountry(mapsByCountry);
			allCases.setCasesByCountryCity(mapsByCountryAndRegion);
			return allCases;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Bean
	public Cases covidData() {
		return getData(null);
		
	}
}
