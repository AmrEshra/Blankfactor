package com.project.services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.project.entity.CountryReport;

@Service
public class ExportDataService {

	@Autowired
	private CountryReportService countryReportService;

	/**
	 * print Data in Console and export it into csv file
	 * @param region
	 */
	public void presentCountryReportList(String region) {

		List<CountryReport> countryReportList = countryReportService.getCountryReport(region);

		// if data found start presenting it
		if (countryReportList.size() > 0) {

			String format = "| %-3d | %-25s | %-20s | %-13s | %-13s | %-13s | \n";
			System.out.format("+-----+---------------------------+----------------------+---------------+---------------+---------------+%n");
			System.out.format("|  #  |           Name            |         Region       |  Total cases  |  Active cases |  Total Tests  |%n");
			System.out.format("+-----+---------------------------+----------------------+---------------+---------------+---------------+%n");

			for (int i = 0; i < countryReportList.size(); i++) {
				System.out.format(format, i + 1, countryReportList.get(i).getName(), countryReportList.get(i).getRegion(), countryReportList.get(i).getTotalCases(),
						countryReportList.get(i).getActiveCases(), countryReportList.get(i).getTotalTests());
			}
			System.out.format("+-----+----------------------+---------------------------+---------------+---------------+---------------+%n");

			exportToCsvFile(countryReportList, region);
		}else { // No data exists
			System.out.println("No Countries Found for region :" + region);
		}
	}

	private void exportToCsvFile(List<CountryReport> countryReportList, String region) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YY_MM_dd");
		LocalDateTime now = LocalDateTime.now();
		String fileName = "export_" + region.replace("/", "-") + "_" + dtf.format(now) + ".csv";

		try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
			writer.writeAll(createCsvData(countryReportList));
			System.out.println(fileName + " generated successfully");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private List<String[]> createCsvData(List<CountryReport> countryReportList) {

		String[] header = { "#","Name", "Region", "Total cases", "Active cases", "Total Tests" };
		List<String[]> list = new ArrayList<>();
		list.add(header);
		for (int i = 0; i < countryReportList.size(); i++) {
			String[] data = { i+1+"", countryReportList.get(i).getName(), countryReportList.get(i).getRegion(), 
					countryReportList.get(i).getTotalCases() + "", countryReportList.get(i).getActiveCases() + "", 
					countryReportList.get(i).getTotalTests() + "" };

			list.add(data);
		}
		return list;
	}
}
