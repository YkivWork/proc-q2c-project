package com.merrillcorp.enterprise.canonical.models;

/**
 * <h1>Project Supp Plan Status</h1>
 * @author podo-crennert
 * @since 2017-10-03
 *
 */
public class ProjectSuppPlanStatus {
	private String masterPlanStatus;
	private String suppPlanStatus;
	private String projectStatus;
	private ProjectStatus eProjectStatus;
	
	/**
	 * <h1>Get Master Plan Status</h1>
	 * @param projectDirective
	 * @param imetadata
	 * @return String - Master Plan Status
	 */
	public String getMasterPlanStatus(ProjectDirective projectDirective, IntegrationMetadata imetadata) {
		if(projectDirective.getFlowType().equals(ProjectFlowType.UPDATEPLANSTATUS)){
			return masterPlanStatus;
		}
		else if(projectDirective.getFlowType().equals(ProjectFlowType.NEWSINGLE) || projectDirective.getFlowType().equals(ProjectFlowType.NEWSPLIT)) {
			return masterPlanStatus;
		}
		else if (imetadata.getLastCompletedProjectStatus().equals(ProjectStatus.BUILDPERIOD.projectStatus()) && eProjectStatus.equals(ProjectStatus.SUSPENDED)) {
			return masterPlanStatus;
		}
		else if (imetadata.getLastCompletedProjectStatus().equals(ProjectStatus.SUSPENDED.projectStatus()) && eProjectStatus.equals(ProjectStatus.BUILDPERIOD)) {
			return masterPlanStatus;
		}
		else if (imetadata.getLastCompletedProjectStatus().equalsIgnoreCase(ProjectStatus.CLOSUREREQUEST.projectStatus()) 
				&& (eProjectStatus.equals(ProjectStatus.HIBERNATION) || eProjectStatus.equals(ProjectStatus.CONTINUATION))){
			return masterPlanStatus;
		}
		else if (imetadata.getLastCompletedProjectStatus().equals(ProjectStatus.CLOSED.projectStatus())
				&& (eProjectStatus.equals(ProjectStatus.ACTIVE) || eProjectStatus.equals(ProjectStatus.CONTINUATION) || eProjectStatus.equals(ProjectStatus.HIBERNATION))) {
			return masterPlanStatus;
		}
		else
			return null;
	}	

	public void setMasterPlanStatus(String masterPlanStatus) {
		this.masterPlanStatus = masterPlanStatus;
	}

	/**
	 * <h1>Get Supp Plan Status</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @param projectDirective
	 * @param imetadata
	 * @return String - Supp Plan Status
	 */
	public String getSuppPlanStatus(ProjectDirective projectDirective, IntegrationMetadata imetadata) {
		if(projectDirective.getFlowType().equals(ProjectFlowType.NEWSINGLE) || projectDirective.getFlowType().equals(ProjectFlowType.NEWSPLIT)) {
			return suppPlanStatus;
		}
		/*else if (imetadata.getLastCompletedProjectStatus().equals(ProjectStatus.BUILDPERIOD.projectStatus()) && eProjectStatus.equals(ProjectStatus.SUSPENDED)) {
			return suppPlanStatus;
		}
		else if (imetadata.getLastCompletedProjectStatus().equals(ProjectStatus.SUSPENDED.projectStatus()) && eProjectStatus.equals(ProjectStatus.BUILDPERIOD)) {
			return suppPlanStatus;
		}
		else if (imetadata.getLastCompletedProjectStatus().equalsIgnoreCase(ProjectStatus.CLOSUREREQUEST.projectStatus()) 
				&& (eProjectStatus.equals(ProjectStatus.HIBERNATION) || eProjectStatus.equals(ProjectStatus.CONTINUATION))){
			return suppPlanStatus;
		}
		else if (imetadata.getLastCompletedProjectStatus().equals(ProjectStatus.CLOSED.projectStatus())
				&& (eProjectStatus.equals(ProjectStatus.ACTIVE) || eProjectStatus.equals(ProjectStatus.CONTINUATION) || eProjectStatus.equals(ProjectStatus.HIBERNATION))) {
			return suppPlanStatus;
		}*/
		else
			return null;
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

	/**
	 * <h1>Project Supp Plan Status Constructor</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @param projectStatus
	 */
	public ProjectSuppPlanStatus(ProjectStatus projectStatus){
		this.eProjectStatus = projectStatus;
		switch(projectStatus){
		case BUILDPERIOD:
			this.setMasterPlanStatus("32");
			this.setSuppPlanStatus("32");
			this.setProjectStatus("Preparation");
			break;
		case ACTIVE:
			this.setMasterPlanStatus("1");
			this.setSuppPlanStatus("1");
			this.setProjectStatus("Active");
			break;
		case CONTINUATION:
			this.setMasterPlanStatus("1");
			this.setSuppPlanStatus("1");
			this.setProjectStatus("Active with Continuation");
			break;
		case CLOSUREREQUEST:
			this.setMasterPlanStatus("2");
			this.setSuppPlanStatus("2");
			this.setProjectStatus("PendingClose");
			break;
		case CLOSED:
			this.setMasterPlanStatus("-3");
			this.setSuppPlanStatus("-3");
			this.setProjectStatus("Closed");
			break;
		case HIBERNATION:
			this.setMasterPlanStatus("1");
			this.setSuppPlanStatus("1");
			this.setProjectStatus("Hibernation");
			break;
		case SUSPENDED:
			this.setMasterPlanStatus("-1");
			this.setSuppPlanStatus("-1");
			this.setProjectStatus("Suspended");
			break;
		default:
			this.setMasterPlanStatus("99");
			this.setSuppPlanStatus("99");
			this.setProjectStatus("NOT KNOWN");
			break;
		}
	}
}
