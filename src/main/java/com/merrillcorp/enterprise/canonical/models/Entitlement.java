package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class Entitlement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4957574981144747169L;
	private String activeEntitlements;
	private String hibernationEntitlements;
	private String pendingCloseEntitlements;
	private String preparationEntitlements;
	private String suspendedEntitlements;
	
	
	public String getActiveEntitlements() {
		return activeEntitlements;
	}
	public void setActiveEntitlements(String activeEntitlements) {
		this.activeEntitlements = activeEntitlements;
	}
	public String getHibernationEntitlements() {
		return hibernationEntitlements;
	}
	public void setHibernationEntitlements(String hibernationEntitlements) {
		this.hibernationEntitlements = hibernationEntitlements;
	}
	public String getPendingCloseEntitlements() {
		return pendingCloseEntitlements;
	}
	public void setPendingCloseEntitlements(String pendingCloseEntitlements) {
		this.pendingCloseEntitlements = pendingCloseEntitlements;
	}
	public String getPreparationEntitlements() {
		return preparationEntitlements;
	}
	public void setPreparationEntitlements(String preparationEntitlements) {
		this.preparationEntitlements = preparationEntitlements;
	}
	public String getSuspendedEntitlements() {
		return suspendedEntitlements;
	}
	public void setSuspendedEntitlements(String suspendedEntitlements) {
		this.suspendedEntitlements = suspendedEntitlements;
	}

}
