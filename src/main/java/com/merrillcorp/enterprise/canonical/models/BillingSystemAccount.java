package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BillingSystemAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6547255075406836736L;
	private String companyName;
	private String accountCurrency;
	private BillingSystemBillingGroup billingGroup;
	private List<BillingSystemContact> contacts;
	private String clientLegalEntity;
	private String billingSystemDunningGroupId;
	private String prorationHostedSuppPlanId;
	private String SMprorationHostedSuppPlanId;
	private BillingSystemMasterPlanInstance billingSystemMasterPlanInstance;
	private String billingSystemAccountId;
	private String billingSystemMasterPlanId;
	
	public BillingSystemMasterPlanInstance getBillingSystemMasterPlanInstance() {
		return billingSystemMasterPlanInstance;
	}
	public void setBillingSystemMasterPlanInstance(BillingSystemMasterPlanInstance billingSystemMasterPlanInstance) {
		this.billingSystemMasterPlanInstance = billingSystemMasterPlanInstance;
	}
	public BillingSystemAccount() {
		this.billingGroup = new BillingSystemBillingGroup();
		this.contacts = new ArrayList<BillingSystemContact>();
		this.billingSystemMasterPlanInstance = new BillingSystemMasterPlanInstance();
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getAccountCurrency() {
		return accountCurrency;
	}
	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}
	public BillingSystemBillingGroup getBillingGroup() {
		return billingGroup;
	}
	public void setBillingGroup(BillingSystemBillingGroup billingGroup) {
		this.billingGroup = billingGroup;
	}
	public List<BillingSystemContact> getContacts() {
		return contacts;
	}
	public void setContacts(List<BillingSystemContact> contacts) {
		this.contacts = contacts;
	}
	public String getClientLegalEntity() {
		return clientLegalEntity;
	}
	public void setClientLegalEntity(String clientLegalEntity) {
		this.clientLegalEntity = clientLegalEntity;
	}
	public String getBillingSystemDunningGroupId() {
		return billingSystemDunningGroupId;
	}
	public void setBillingSystemDunningGroupId(String billingSystemDunningGroupId) {
		this.billingSystemDunningGroupId = billingSystemDunningGroupId;
	}
	public String getProrationHostedSuppPlanId() {
		return prorationHostedSuppPlanId;
	}
	public void setProrationHostedSuppPlanId(String prorationHostedSuppPlanId) {
		this.prorationHostedSuppPlanId = prorationHostedSuppPlanId;
	}
	public String getSMprorationHostedSuppPlanId() {
		return SMprorationHostedSuppPlanId;
	}
	public void setSMprorationHostedSuppPlanId(String sMprorationHostedSuppPlanId) {
		SMprorationHostedSuppPlanId = sMprorationHostedSuppPlanId;
	}
	public String getBillingSystemAccountId() {
		return billingSystemAccountId;
	}
	public void setBillingSystemAccountId(String billingSystemAccountId) {
		this.billingSystemAccountId = billingSystemAccountId;
	}
	public String getBillingSystemMasterPlanId() {
		return billingSystemMasterPlanId;
	}
	public void setBillingSystemMasterPlanId(String billingSystemMasterPlanId) {
		this.billingSystemMasterPlanId = billingSystemMasterPlanId;
	}

}
