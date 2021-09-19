package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountryReport {
 
	@Id
    private String name;
    private String region;
	private Integer totalCases;
    private Integer totalTests;
    private Integer activeCases;
 
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
 
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public Integer getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(Integer totalCases) {
		this.totalCases = totalCases;
	}

	public Integer getTotalTests() {
		return totalTests;
	}

	public void setTotalTests(Integer totalTests) {
		this.totalTests = totalTests;
	}

	public Integer getActiveCases() {
		return activeCases;
	}

	public void setActiveCases(Integer activeCases) {
		this.activeCases = activeCases;
	}
 
}