package com.project.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.project.entity.CountryReport;

@Service
public class ExtractDataService {

	/**
	 * Read Data table from HTML page
	 * @return
	 * @throws Exception
	 */
	public List<CountryReport> readDate() throws Exception {
		List<CountryReport> countryReportList = new ArrayList<CountryReport>();
		try {
			// connect to a URL
			Connection connection = Jsoup.connect("https://www.worldometers.info/coronavirus/");
			// specify user agent
			connection.userAgent("Chrome/93.0.4577.63");

			// get the HTML document
			Document document = connection.get();
			// get first table
			Element table = document.select("table").get(0);
			// get all rows
			Elements rows = table.select("tr");

			// for each row starting from row No. 9 to 231
			for (int i = 9; i <= 231; i++) {
				Element row = rows.get(i);
				// get all columns and insert into CountryReport table
				Elements columns = row.select("td");
				CountryReport countryReport = new CountryReport();
				String countryName = columns.get(1).text();
				String region = columns.get(15).text().isEmpty() ? null : columns.get(15).text();
				Integer totalCases = columns.get(2).text() == null || columns.get(2).text().equals("N/A") || columns.get(2).text().isEmpty() ? null : new Integer(columns.get(2).text().replace(",", ""));
				Integer totalTests = columns.get(12).text() == null || columns.get(12).text().equals("N/A") || columns.get(12).text().isEmpty() ? null : new Integer(columns.get(12).text().replace(",", ""));
				Integer activeCases = columns.get(8).text() == null || columns.get(8).text().equals("N/A") || columns.get(8).text().isEmpty()? null : new Integer(columns.get(8).text().replace(",", ""));
				
				countryReport.setName(countryName);
				countryReport.setRegion(region);
				countryReport.setTotalCases(totalCases);
				countryReport.setTotalTests(totalTests);
				countryReport.setActiveCases(activeCases);
				countryReportList.add(countryReport);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			return countryReportList;
		}
	}
}
