package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class SuppPlanServiceItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7421185464181911496L;

	private String clientServiceId;
	private String clientServiceLocationId;

	//TODO The rest of these are not in the CanonicalModel
	private String suppPlanInstanceNumber;
	private String serviceLocationNumber;
	private String destinationContactNumber;
	private String serviceNumber;
	
	public String getSuppPlanInstanceNumber() {
		return suppPlanInstanceNumber;
	}
	public void setSuppPlanInstanceNumber(String suppPlanInstanceNumber) {
		this.suppPlanInstanceNumber = suppPlanInstanceNumber;
	}
	public String getServiceLocationNumber() {
		return serviceLocationNumber;
	}
	public void setServiceLocationNumber(String serviceLocationNumber) {
		this.serviceLocationNumber = serviceLocationNumber;
	}
	public String getDestinationContactNumber() {
		return destinationContactNumber;
	}
	public void setDestinationContactNumber(String destinationContactNumber) {
		this.destinationContactNumber = destinationContactNumber;
	}
	public String getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public String getClientServiceId() {
		return clientServiceId;
	}
	public void setClientServiceId(String clientServiceId) {
		this.clientServiceId = clientServiceId;
	}
	public String getClientServiceLocationId() {
		return clientServiceLocationId;
	}
	public void setClientServiceLocationId(String clientServiceLocationId) {
		this.clientServiceLocationId = clientServiceLocationId;
	}

}
