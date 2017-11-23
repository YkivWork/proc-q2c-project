package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class SalesRep implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9212881145835966150L;
	private Boolean isPrimary;
	private Double splitPercentage;
	private String employeeNumber;
	private String name;
	
	public Boolean getIsPrimary() {
		return isPrimary;
	}
	public void setIsPrimary(Boolean isPrimary) {
		this.isPrimary = isPrimary;
	}
	public Double getSplitPercentage() {
		return splitPercentage;
	}
	public void setSplitPercentage(Double splitPercentage) {
		this.splitPercentage = splitPercentage;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
