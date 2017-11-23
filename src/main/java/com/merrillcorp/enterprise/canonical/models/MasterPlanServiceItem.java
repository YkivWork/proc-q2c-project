package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class MasterPlanServiceItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2498146579987063784L;
	private String clientServiceLocationId;
	private String serviceNumber;
	private String serviceLocationNumber;
	private String clientSerivceId;
	private String destinationContactNumber;
	
	public String getServiceNumber() {
		return serviceNumber;
	}
	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}
	public String getServiceLocationNumber() {
		return serviceLocationNumber;
	}
	public void setServiceLocationNumber(String serviceLocationNumber) {
		this.serviceLocationNumber = serviceLocationNumber;
	}
	public String getClientSerivceId() {
		return clientSerivceId;
	}
	public void setClientSerivceId(String clientSerivceId) {
		this.clientSerivceId = clientSerivceId;
	}
	public String getDestinationContactNumber() {
		return destinationContactNumber;
	}
	public void setDestinationContactNumber(String destinationContactNumber) {
		this.destinationContactNumber = destinationContactNumber;
	}
	public String getClientServiceLocationId() {
		return clientServiceLocationId;
	}
	public void setClientServiceLocationId(String clientServiceLocationId) {
		this.clientServiceLocationId = clientServiceLocationId;
	}

}
