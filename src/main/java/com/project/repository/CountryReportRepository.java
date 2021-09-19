package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.CountryReport;

@Repository
public interface CountryReportRepository extends JpaRepository<CountryReport, String>{
	
	List<CountryReport> findByRegionIgnoreCase(String region);
}

