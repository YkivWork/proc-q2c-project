package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BillingSystemSuppPlanInstance implements Serializable {

	/**
	 * 
	 */
	//TODO FIXME Lots of these fields are not listed in the canonicalModel doc nor
	//in the excel sheet
	private static final long serialVersionUID = 7583584761203321018L;
	private String clientPlanId;
	//TODO Difference of this and suppPlanNumber? Reference the schema?
	private String suppPlanInstanceNumber; //TODO Same as planInstanceNumber?

	//existing_client_plan_instance_id
	private String clientSuppPlanInstanceId; //TODO is this the same clientPlanInstanceId?

	private String suppPlanInstanceDescription;
	private String suppPlanNumber; //TODO Same as planInstanceNumber?
	private String suppPlanUnits;
	private String altRateScheduleNumber;
	private String lastArrearsBillThroughDate;
	private String lastBillDate;
	private String lastBillThroughDate;
	private String nextBillDate;
	private String planDate;
	private String statusDate;
	private String suppPlanInstanceStatusCd; //TODO Same as planStatusCode?
	private String suppPlanInstanceStatus;
	private String parentPlanInstanceNumber;
	private String clientParentPlanInstanceId;
	private String recurringBillingInterval="1";
	private String usageBillingInterval="1";
	private String rolloverPlanStatus;
	private String rolloverPlanStatusDuration;
	private String rolloverPlanStatusUOMCd;
	private String planDeprovisionDate;
	private String poNumber;
	private Integer usageAccumulationResetMonths;
	private List<SuppPlanServiceItem> suppPlanServices;
	private List<CustomRate> customRates;
	private SuppPlanInstanceField suppPlanInstanceField;
	
	
	public String getSuppPlanUnits() {
		return suppPlanUnits;
	}
	public void setSuppPlanUnits(String suppPlanUnits) {
		this.suppPlanUnits = suppPlanUnits;
	}
	public String getAltRateScheduleNumber() {
		return altRateScheduleNumber;
	}
	public void setAltRateScheduleNumber(String altRateScheduleNumber) {
		this.altRateScheduleNumber = altRateScheduleNumber;
	}
	public String getLastArrearsBillThroughDate() {
		return lastArrearsBillThroughDate;
	}
	public void setLastArrearsBillThroughDate(String lastArrearsBillThroughDate) {
		this.lastArrearsBillThroughDate = lastArrearsBillThroughDate;
	}
	public String getLastBillDate() {
		return lastBillDate;
	}
	public void setLastBillDate(String lastBillDate) {
		this.lastBillDate = lastBillDate;
	}
	public String getLastBillThroughDate() {
		return lastBillThroughDate;
	}
	public void setLastBillThroughDate(String lastBillThroughDate) {
		this.lastBillThroughDate = lastBillThroughDate;
	}
	public String getNextBillDate() {
		return nextBillDate;
	}
	public void setNextBillDate(String nextBillDate) {
		this.nextBillDate = nextBillDate;
	}
	public String getPlanDate() {
		return planDate;
	}
	public void setPlanDate(String planDate) {
		this.planDate = planDate;
	}
	public String getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	public String getSuppPlanInstanceStatusCd() {
		return suppPlanInstanceStatusCd;
	}
	public void setSuppPlanInstanceStatusCd(String suppPlanInstanceStatusCd) {
		this.suppPlanInstanceStatusCd = suppPlanInstanceStatusCd;
	}
	public String getSuppPlanInstanceStatus() {
		return suppPlanInstanceStatus;
	}
	public void setSuppPlanInstanceStatus(String suppPlanInstanceStatus) {
		this.suppPlanInstanceStatus = suppPlanInstanceStatus;
	}
	public String getParentPlanInstanceNumber() {
		return parentPlanInstanceNumber;
	}
	public void setParentPlanInstanceNumber(String parentPlanInstanceNumber) {
		this.parentPlanInstanceNumber = parentPlanInstanceNumber;
	}
	public String getClientParentPlanInstanceId() {
		return clientParentPlanInstanceId;
	}
	public void setClientParentPlanInstanceId(String clientParentPlanInstanceId) {
		this.clientParentPlanInstanceId = clientParentPlanInstanceId;
	}
	public String getRecurringBillingInterval() {
		return recurringBillingInterval;
	}
	public void setRecurringBillingInterval(String recurringBillingInterval) {
		this.recurringBillingInterval = recurringBillingInterval;
	}
	public String getUsageBillingInterval() {
		return usageBillingInterval;
	}
	public void setUsageBillingInterval(String usageBillingInterval) {
		this.usageBillingInterval = usageBillingInterval;
	}
	public String getRolloverPlanStatus() {
		return rolloverPlanStatus;
	}
	public void setRolloverPlanStatus(String rolloverPlanStatus) {
		this.rolloverPlanStatus = rolloverPlanStatus;
	}
	public String getRolloverPlanStatusDuration() {
		return rolloverPlanStatusDuration;
	}
	public void setRolloverPlanStatusDuration(String rolloverPlanStatusDuration) {
		this.rolloverPlanStatusDuration = rolloverPlanStatusDuration;
	}
	public String getRolloverPlanStatusUOMCd() {
		return rolloverPlanStatusUOMCd;
	}
	public void setRolloverPlanStatusUOMCd(String rolloverPlanStatusUOMCd) {
		this.rolloverPlanStatusUOMCd = rolloverPlanStatusUOMCd;
	}
	public String getPlanDeprovisionDate() {
		return planDeprovisionDate;
	}
	public void setPlanDeprovisionDate(String planDeprovisionDate) {
		this.planDeprovisionDate = planDeprovisionDate;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getSuppPlanInstanceNumber() {
		return suppPlanInstanceNumber;
	}
	public void setSuppPlanInstanceNumber(String suppPlanInstanceNumber) {
		this.suppPlanInstanceNumber = suppPlanInstanceNumber;
	}
	public String getClientSuppPlanInstanceId() {
		return clientSuppPlanInstanceId;
	}
	public void setClientSuppPlanInstanceId(String clientSuppPlanInstanceId) {
		this.clientSuppPlanInstanceId = clientSuppPlanInstanceId;
	}
	public String getSuppPlanInstanceDescription() {
		return suppPlanInstanceDescription;
	}
	public void setSuppPlanInstanceDescription(String suppPlanInstanceDescription) {
		this.suppPlanInstanceDescription = suppPlanInstanceDescription;
	}
	public String getSuppPlanNumber() {
		return suppPlanNumber;
	}
	public void setSuppPlanNumber(String suppPlanNumber) {
		this.suppPlanNumber = suppPlanNumber;
	}

	
	public BillingSystemSuppPlanInstance(){
		this.customRates = new ArrayList<CustomRate>();
		this.suppPlanServices = new ArrayList<SuppPlanServiceItem>();
		this.setSuppPlanInstanceField(new SuppPlanInstanceField());
	}
	public String getClientPlanId() {
		return clientPlanId;
	}
	public void setClientPlanId(String clientPlanId) {
		this.clientPlanId = clientPlanId;
	}
	public List<SuppPlanServiceItem> getSuppPlanServices() {
		return suppPlanServices;
	}
	public void setSuppPlanServices(List<SuppPlanServiceItem> suppPlanServices) {
		this.suppPlanServices = suppPlanServices;
	}
	public List<CustomRate> getCustomRates() {
		return customRates;
	}
	public void setCustomRates(List<CustomRate> customRates) {
		this.customRates = customRates;
	}
	public Integer getUsageAccumulationResetMonths() {
		return usageAccumulationResetMonths;
	}
	public void setUsageAccumulationResetMonths(Integer usageAccumulationResetMonths) {
		this.usageAccumulationResetMonths = usageAccumulationResetMonths;
	}
	public SuppPlanInstanceField getSuppPlanInstanceField() {
		return suppPlanInstanceField;
	}
	public void setSuppPlanInstanceField(SuppPlanInstanceField suppPlanInstanceField) {
		this.suppPlanInstanceField = suppPlanInstanceField;
	}	
	
	
}
