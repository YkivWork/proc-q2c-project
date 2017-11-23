package com.merrillcorp.enterprise.canonical.models;

/**
 * <h1>Project Status</h1>
 * @author podo-crennert
 * @since 2017-10-03
 *
 */
public enum ProjectStatus {
	BUILDPERIOD("Build Period"),
	ACTIVE("Active"),
	CLOSUREREQUEST("Closure_Requested"),
	CLOSED("Closed"),
	HIBERNATION("Hibernation"),
	SUSPENDED("Suspended"),
	CONTINUATION("Active with Continuation");
	
	private String projectStatus;
	
	ProjectStatus(String projectStatus){
		this.projectStatus = projectStatus;
	}
	
	public String projectStatus(){
		return projectStatus;
	}
}
