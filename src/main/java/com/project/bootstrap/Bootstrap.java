package com.project.bootstrap;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.entity.CountryReport;
import com.project.services.CountryReportService;
import com.project.services.ExportDataService;
import com.project.services.ExtractDataService;

@Component
public class Bootstrap implements CommandLineRunner {

	@Autowired
	private ExtractDataService extractDataService;

	@Autowired
	private CountryReportService countryReportService;

	@Autowired
	private ExportDataService exportDataService;

	@Override
	public void run(String... args) throws Exception {
		// Read Data from HTML Page
		List<CountryReport> countryReportList = extractDataService.readDate();
		
		// save Data to Country Report
		countryReportService.saveCountryReportList(countryReportList);
		
		// present data and export csv file
		exportCountryReport();
	}

	private void exportCountryReport() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.format("+--------------------------------------------------------------------------------------------+%n");
			System.out.format("| Available Regions : Africa, Asia , Australia/Oceania, Europe, North America, South America |%n");
			System.out.format("+--------------------------------------------------------------------------------------------+%n");
			System.out.print("Enter Region name (for All Regions user Enter) : ");
			String region = scanner.nextLine();
			exportDataService.presentCountryReportList(region);
		}

	}
}
