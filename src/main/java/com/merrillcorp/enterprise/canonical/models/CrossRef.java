package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class CrossRef implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8206165880059225168L;
	private String entityTypeKey;
	private String entityInstanceId;
	private String identifierTypeKey;
	private String identifierValue;
	private String qualifier1Key;
	private String qualifier1Value;
	private String qualifier2Key;
	private String qualifier2Value;
	private String startDate;
	private String endDate;
	private Integer ISDELETED;
	private Boolean doEndDate=Boolean.FALSE;
	
	
	public String getEntityTypeKey() {
		return entityTypeKey;
	}
	public void setEntityTypeKey(String entityTypeKey) {
		this.entityTypeKey = entityTypeKey;
	}
	public String getEntityInstanceId() {
		return entityInstanceId;
	}
	public void setEntityInstanceId(String entityInstanceId) {
		this.entityInstanceId = entityInstanceId;
	}
	public String getIdentifierTypeKey() {
		return identifierTypeKey;
	}
	public void setIdentifierTypeKey(String identifierTypeKey) {
		this.identifierTypeKey = identifierTypeKey;
	}
	public String getIdentifierValue() {
		return identifierValue;
	}
	public void setIdentifierValue(String identifierValue) {
		this.identifierValue = identifierValue;
	}
	public String getQualifier1Key() {
		return qualifier1Key;
	}
	public void setQualifier1Key(String qualifier1Key) {
		this.qualifier1Key = qualifier1Key;
	}
	public String getQualifier1Value() {
		return qualifier1Value;
	}
	public void setQualifier1Value(String qualifier1Value) {
		this.qualifier1Value = qualifier1Value;
	}
	public String getQualifier2Key() {
		return qualifier2Key;
	}
	public void setQualifier2Key(String qualifier2Key) {
		this.qualifier2Key = qualifier2Key;
	}
	public String getQualifier2Value() {
		return qualifier2Value;
	}
	public void setQualifier2Value(String qualifier2Value) {
		this.qualifier2Value = qualifier2Value;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Integer getIsDeleted() {
		return ISDELETED;
	}
	public void setIsDeleted(Integer ISDELETED) {
		this.ISDELETED = ISDELETED;
	}
	public Boolean getDoEndDate() {
		return doEndDate;
	}
	public void setDoEndDate(Boolean doEndDate) {
		this.doEndDate = doEndDate;
	}

}
