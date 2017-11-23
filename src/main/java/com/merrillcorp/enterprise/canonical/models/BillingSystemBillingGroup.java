package com.merrillcorp.enterprise.canonical.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BillingSystemBillingGroup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3013454563546311755L;
	private String name;
	private String statementTemplate;
	private String creditNoteTemplate;
	private String creditMemoTemplate;
	private String billingGroupNumber;
	private String billingGroupDescription;
	private String clientDefBillingGroupId;
	private String notifyMethod;
	private String notifyTemplateGroup;
	private String paymentOption;
	private String primaryPaymentMethodId;
	private String backupPaymentMethodId;
	private String rebillTemplate;

	public String toString() {
		return new ToStringBuilder(this)
				.append("name", name)
                .append("billingGroupNumber", billingGroupNumber)
				.append("billingGroupDescription", billingGroupDescription)
				.toString();
	}
	
	public String getRebillTemplate() {
		return rebillTemplate;
	}
	public void setRebillTemplate(String rebillTemplate) {
		this.rebillTemplate = rebillTemplate;
	}
	public String getBillingGroupNumber() {
		return billingGroupNumber;
	}
	public void setBillingGroupNumber(String billingGroupNumber) {
		this.billingGroupNumber = billingGroupNumber;
	}
	public String getBillingGroupDescription() {
		return billingGroupDescription;
	}
	public void setBillingGroupDescription(String billingGroupDescription) {
		this.billingGroupDescription = billingGroupDescription;
	}
	public String getClientDefBillingGroupId() {
		return clientDefBillingGroupId;
	}
	public void setClientDefBillingGroupId(String clientDefBillingGroupId) {
		this.clientDefBillingGroupId = clientDefBillingGroupId;
	}
	public String getNotifyMethod() {
		return notifyMethod;
	}
	public void setNotifyMethod(String notifyMethod) {
		this.notifyMethod = notifyMethod;
	}
	public String getNotifyTemplateGroup() {
		return notifyTemplateGroup;
	}
	public void setNotifyTemplateGroup(String notifyTemplateGroup) {
		this.notifyTemplateGroup = notifyTemplateGroup;
	}
	public String getPaymentOption() {
		return paymentOption;
	}
	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}
	public String getPrimaryPaymentMethodId() {
		return primaryPaymentMethodId;
	}
	public void setPrimaryPaymentMethodId(String primaryPaymentMethodId) {
		this.primaryPaymentMethodId = primaryPaymentMethodId;
	}
	public String getBackupPaymentMethodId() {
		return backupPaymentMethodId;
	}
	public void setBackupPaymentMethodId(String backupPaymentMethodId) {
		this.backupPaymentMethodId = backupPaymentMethodId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatementTemplate() {
		return statementTemplate;
	}
	public void setStatementTemplate(String statementTemplate) {
		this.statementTemplate = statementTemplate;
	}
	public String getCreditNoteTemplate() {
		return creditNoteTemplate;
	}
	public void setCreditNoteTemplate(String creditNoteTemplate) {
		this.creditNoteTemplate = creditNoteTemplate;
	}
	public String getCreditMemoTemplate() {
		return creditMemoTemplate;
	}
	public void setCreditMemoTemplate(String creditMemoTemplate) {
		this.creditMemoTemplate = creditMemoTemplate;
	}

}
