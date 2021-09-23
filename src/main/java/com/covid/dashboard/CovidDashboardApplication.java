package com.covid.dashboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.covid.dashboard.bean.Case;
import com.covid.dashboard.bean.Cases;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@SpringBootApplication
public class CovidDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidDashboardApplication.class, args);
	}
	
	@Bean
	public Cases readerFor() {
		 java.net.URL url = null;
         Date date = new Date();
         SimpleDateFormat DateFor = new SimpleDateFormat("MM-dd-yyyy");
         String stringDate= DateFor.format(date);
         System.out.println(stringDate);
         try {
             url = new java.net.URL("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/"+"01-01-2021"+".csv");
             java.net.URLConnection uc;
             uc = url.openConnection();

             uc.setRequestProperty("X-Requested-With", "Curl");
             BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
             CsvSchema casesSchema = CsvSchema.emptySchema().withHeader();
 	    	CsvMapper csvMapper = new CsvMapper();
 	    	MappingIterator<Case> cases = csvMapper.readerFor(Case.class)
 	    	  .with(casesSchema)
 	    	  .readValues(reader);
 	    	Cases casesList = new Cases();
 	    	List<Case> map = cases.readAll();
 	    	System.out.println(map);
 	    	return casesList;
         } catch (IOException e) {
             e.printStackTrace();
         }
         return null;
	}
}
