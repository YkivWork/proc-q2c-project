package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class ProjectAndPlanStatusMapping implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1036131530428104447L;
	private String masterPlanStatus;
	private String suppPlanStatus;
	private String projectStatus;
	
	
	public String getMasterPlanStatus() {
		return masterPlanStatus;
	}
	public void setMasterPlanStatus(String masterPlanStatus) {
		this.masterPlanStatus = masterPlanStatus;
	}
	public String getSuppPlanStatus() {
		return suppPlanStatus;
	}	
	public void setSuppPlanStatus(String suppPlanStatus) {
		this.suppPlanStatus = suppPlanStatus;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	
}
