package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BilledPartySourceData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1763676636189081526L;
	private List<CrossRef> crossRefs;
	private String billable;
	private String billingSplit;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String customerOrderNumber;
	private BillingCompany billingCompany;
	private BillingAddress billingAddress;
	private Boolean retroChange;



	public String getCustomerOrderNumber() {
		return customerOrderNumber;
	}

	public void setCustomerOrderNumber(String customerOrderNumber) {
		this.customerOrderNumber = customerOrderNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BilledPartySourceData(){
		this.crossRefs = new ArrayList<CrossRef>();
		this.billingCompany = new BillingCompany();
		this.billingAddress = new  BillingAddress();
	}
	
	public List<CrossRef> getCrossRefs() {
		return crossRefs;
	}
	public void setCrossRefs(List<CrossRef> crossRefs) {
		this.crossRefs = crossRefs;
	}
	public String getBillable() {
		return billable;
	}
	public void setBillable(String billable) {
		this.billable = billable;
	}
	public String getBillingSplit() {
		return billingSplit;
	}
	public void setBillingSplit(String billingSplit) {
		this.billingSplit = billingSplit;
	}
	public BillingCompany getBillingCompany() {
		return billingCompany;
	}
	public void setBillingCompany(BillingCompany billingCompany) {
		this.billingCompany = billingCompany;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * TODO I was going to write tests for these two method, but I'm not finding them used anywhere
	 * @return
	 */
	public String getVATCountryCode(){
		if(this.getBillingCompany().getVatRegistration() == null )
			return null;
		else
			return this.getBillingAddress().getCountry();
			
	}
	
	public String getBillingGroupName(String currency){
		return this.getBillingCompany().getOracleAccountId() + "-" + this.getBillingAddress().getOracleSiteId() + "-" + currency;
	}

	public Boolean getRetroChange() {
		return retroChange;
	}

	public void setRetroChange(Boolean retroChange) {
		this.retroChange = retroChange;
	}

}
