package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class BillingCompany implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4508585375628249082L;
	private String name;
	private String sfdcId;
	private String oracleAccountId;
	private String oracleAccountNumber;
	private String vatRegistration;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSfdcId() {
		return sfdcId;
	}
	public void setSfdcId(String sfdcId) {
		this.sfdcId = sfdcId;
	}
	public String getOracleAccountId() { return oracleAccountId; }
	public void setOracleAccountId(String oracleAccountId) {
		this.oracleAccountId = oracleAccountId;
	}
	public String getOracleAccountNumber() { return oracleAccountNumber; }
	public void setOracleAccountNumber(String oracleNumber) { this.oracleAccountNumber = oracleNumber; }
	public String getVatRegistration() { return vatRegistration; }
	public void setVatRegistration(String vatRegistration) {
		this.vatRegistration = vatRegistration;
	}
	

}
