package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class CustomRate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 390902731666280144L;
	private String customRateClientServiceId;
	private String customRateSequenceNumber; //TODO Needed or infer off of array index? Reconcile with schema and/or Karl
	private Double customRateFromUnit;
	private Double customRateToUnit;
	private String customRatePerUnit;
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCustomRateSequenceNumber() {
		return customRateSequenceNumber;
	}
	public void setCustomRateSequenceNumber(String customRateSequenceNumber) {
		this.customRateSequenceNumber = customRateSequenceNumber;
	}
	public String getCustomRateClientServiceId() {
		return customRateClientServiceId;
	}
	public void setCustomRateClientServiceId(String customRateClientServiceId) {
		this.customRateClientServiceId = customRateClientServiceId;
	}
	public Double getCustomRateFromUnit() {
		return customRateFromUnit;
	}
	public void setCustomRateFromUnit(Double customRateFromUnit) {
		this.customRateFromUnit = customRateFromUnit;
	}
	public Double getCustomRateToUnit() {
		return customRateToUnit;
	}
	public void setCustomRateToUnit(Double customRateToUnit) {
		this.customRateToUnit = customRateToUnit;
	}
	public String getCustomRatePerUnit() {
		return customRatePerUnit;
	}
	public void setCustomRatePerUnit(String customRatePerUnit) {
		this.customRatePerUnit = customRatePerUnit;
	}

}
