package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class IntegrationMetadata implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3264437482268529270L;
	private String Id;
	private String lastIntegrationStartDate;
	private String lastIntegrationTransactionId;
	private String lastRunResults;
	private String lastRunErrorDetails;
	private String currentRunStartedDate;
	private String currentRunTransactionId;
	private String uncertainStateInAria;
	private String uncertainStateInDatasiteOne;
	private String uncertainStateInOracle;
	private String ariaCreatedDate;
	private String datasiteOneCreatedDate;
	private String oracleCreatedDate;
	private String aggregateDetailsSinceLastSuccess; 
	private String lastCompletedProjectStatus; 
	private String pendingStatusChange; 
	private String pendingStatusChangeDate;
	
	
	public String getLastIntegrationStartDate() {
		return lastIntegrationStartDate;
	}
	public void setLastIntegrationStartDate(String lastIntegrationStartDate) {
		this.lastIntegrationStartDate = lastIntegrationStartDate;
	}
	public String getLastIntegrationTransactionId() {
		return lastIntegrationTransactionId;
	}
	public void setLastIntegrationTransactionId(String lastIntegrationTransactionId) {
		this.lastIntegrationTransactionId = lastIntegrationTransactionId;
	}
	public String getLastRunResults() {
		return lastRunResults;
	}
	public void setLastRunResults(String lastRunResults) {
		this.lastRunResults = lastRunResults;
	}
	public String getLastRunErrorDetails() {
		return lastRunErrorDetails;
	}
	public void setLastRunErrorDetails(String lastRunErrorDetails) {
		this.lastRunErrorDetails = lastRunErrorDetails;
	}
	public String getCurrentRunStartedDate() {
		return currentRunStartedDate;
	}
	public void setCurrentRunStartedDate(String currentRunStartedDate) {
		this.currentRunStartedDate = currentRunStartedDate;
	}
	public String getCurrentRunTransactionId() {
		return currentRunTransactionId;
	}
	public void setCurrentRunTransactionId(String currentRunTransactionId) {
		this.currentRunTransactionId = currentRunTransactionId;
	}
	public String getUncertainStateInAria() {
		return uncertainStateInAria;
	}
	public void setUncertainStateInAria(String uncertainStateInAria) {
		this.uncertainStateInAria = uncertainStateInAria;
	}
	public String getUncertainStateInDatasiteOne() {
		return uncertainStateInDatasiteOne;
	}
	public void setUncertainStateInDatasiteOne(String uncertainStateInDatasiteOne) {
		this.uncertainStateInDatasiteOne = uncertainStateInDatasiteOne;
	}
	public String getUncertainStateInOracle() {
		return uncertainStateInOracle;
	}
	public void setUncertainStateInOracle(String uncertainStateInOracle) {
		this.uncertainStateInOracle = uncertainStateInOracle;
	}
	public String getAriaCreatedDate() {
		return ariaCreatedDate;
	}
	public void setAriaCreatedDate(String ariaCreatedDate) {
		this.ariaCreatedDate = ariaCreatedDate;
	}
	public String getDatasiteOneCreatedDate() {
		return datasiteOneCreatedDate;
	}
	public void setDatasiteOneCreatedDate(String datasiteOneCreatedDate) {
		this.datasiteOneCreatedDate = datasiteOneCreatedDate;
	}
	public String getOracleCreatedDate() {
		return oracleCreatedDate;
	}
	public void setOracleCreatedDate(String oracleCreatedDate) {
		this.oracleCreatedDate = oracleCreatedDate;
	}
	public String getAggregateDetailsSinceLastSuccess() {
		return aggregateDetailsSinceLastSuccess;
	}
	public void setAggregateDtailsSinceLastSuccess(String aggregateDetailsSinceLastSuccess) {
		this.aggregateDetailsSinceLastSuccess = aggregateDetailsSinceLastSuccess;
	}
	public String getLastCompletedProjectStatus() {
		return lastCompletedProjectStatus;
	}
	public void setLastCompletedProjectStatus(String lastCompletedProjectStatus) {
		this.lastCompletedProjectStatus = lastCompletedProjectStatus;
	}
	public String getPendingStatusChange() {
		return pendingStatusChange;
	}
	public void setPendingStatusChange(String pendingStatusChange) {
		this.pendingStatusChange = pendingStatusChange;
	}
	public String getPendingStatusChangeDate() {
		return pendingStatusChangeDate;
	}
	public void setPendingStatusChangeDate(String pendingStatusChangeDate) {
		this.pendingStatusChangeDate = pendingStatusChangeDate;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
}
