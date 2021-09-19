package com.project.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CountryReport;
import com.project.repository.CountryReportRepository;

@Service
public class CountryReportService {

	@Autowired
	private CountryReportRepository countryReportRespository;
	
	/**
	 * save all country Report
	 * @param countryReportList
	 */
	public void saveCountryReportList(List<CountryReport> countryReportList) {

		countryReportRespository.saveAll(countryReportList);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/dd");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(countryReportRespository.count() + " Country loaded for " + dtf.format(now));
	}
	
	/**
	 * Get Country Report by Region
	 * @param region
	 * @return List<CountryReport>
	 */
	public List<CountryReport> getCountryReport(String region) {
		// load all Countries
		if(region.isEmpty())
			return countryReportRespository.findAll();
		else
			// load Country by region
			return countryReportRespository.findByRegionIgnoreCase(region);
	}
}
