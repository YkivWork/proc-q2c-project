package com.merrillcorp.enterprise.canonical.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class ProjectDirective implements Serializable {

	/**
	 * 
	 */
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private static final long serialVersionUID = 3158765422540974830L;
	private Boolean ariaDoWrite=Boolean.FALSE;
	private Boolean ariaAssignmentDirective=Boolean.FALSE;
	private Boolean ariaIncludeCustomRates=Boolean.FALSE;
	private Boolean ariaIncludePlanInstanceStatus=Boolean.FALSE;
	private Boolean newToAria=Boolean.FALSE;
	private Boolean splitBill=Boolean.FALSE;
	private Boolean prorationNeeded=Boolean.FALSE;
	private ProjectFlowType flowType;
	private Boolean updateDSO=Boolean.FALSE;
	private Boolean createDSO=Boolean.FALSE;
	private Boolean createMDR=Boolean.FALSE;
	private Boolean isManualDataRoom=Boolean.FALSE; 
	private String fromProjState; 
	private String toProjState; 
	private String curPendingProjState;
	private Boolean updatePlanStatus=Boolean.FALSE;
	private Boolean ariaSendStatus=Boolean.FALSE;
	private Boolean reprocessStatus=Boolean.FALSE;
	
	
	public Boolean getIsManualDataRoom() {
		return isManualDataRoom;
	}
	public void setIsManualDataRoom(Boolean isManualDataRoom) {
		this.isManualDataRoom = isManualDataRoom;
	}
	public Boolean getProrationNeeded() {
		return prorationNeeded;
	}
	public void setProrationNeeded(Boolean prorationNeeded) {
		this.prorationNeeded = prorationNeeded;
	}
	public Boolean getUpdateDSO() {
		return updateDSO;
	}
	public void setUpdateDSO(Boolean updateDSO) {
		this.updateDSO = updateDSO;
	}
	public Boolean getCreateDSO() {
		return createDSO;
	}
	public void setCreateDSO(Boolean createDSO) {
		this.createDSO = createDSO;
	}
	public Boolean getCreateMDR() {
		return createMDR;
	}
	public void setCreateMDR(Boolean createMDR) {
		this.createMDR = createMDR;
	}
	public Boolean getNewToAria() {
		return newToAria;
	}
	public void setNewToAria(Boolean newToAria) {
		this.newToAria = newToAria;
	}
	public Boolean getSplitBill() {
		return splitBill;
	}
	public void setSplitBill(Boolean splitBill) {
		this.splitBill = splitBill;
	}

	//TODO Change this to be more of a IsUpdateSingle so our choice/when's will be cleaner
	public ProjectFlowType getFlowType() {
		return flowType;
	}
	public void setFlowType(ProjectFlowType flowType) {
		this.flowType = flowType;
	}
	public Boolean getAriaDoWrite() {
		return ariaDoWrite;
	}
	public void setAriaDoWrite(Boolean ariaDoWrite) {
		this.ariaDoWrite = ariaDoWrite;
	}
	public Boolean getAriaAssignmentDirective() {
		return ariaAssignmentDirective;
	}
	public void setAriaAssignmentDirective(Boolean ariaAssignmentDirective) {
		this.ariaAssignmentDirective = ariaAssignmentDirective;
	}
	public Boolean getAriaIncludeCustomRates() {
		return ariaIncludeCustomRates;
	}
	public void setAriaIncludeCustomRates(Boolean ariaIncludeCustomRates) {
		this.ariaIncludeCustomRates = ariaIncludeCustomRates;
	}
	public Boolean getAriaIncludePlanInstanceStatus() {
		return ariaIncludePlanInstanceStatus;
	}
	public void setAriaIncludePlanInstanceStatus(Boolean ariaIncludePlanInstanceStatus) {
		this.ariaIncludePlanInstanceStatus = ariaIncludePlanInstanceStatus;
	}
	public String getFromProjState() {
		return fromProjState;
	}
	public void setFromProjState(String fromProjState) {
		String oldVal = this.fromProjState;
		this.fromProjState = fromProjState;
		pcs.firePropertyChange("fromProjState", oldVal, fromProjState);
	}
	public String getToProjState() {
		return toProjState;
	}
	public void setToProjState(String toProjState) {
		String oldVal = this.toProjState;		
		this.toProjState = toProjState;
		pcs.firePropertyChange("toProjState", oldVal, toProjState);
	}
	public String getCurPendingProjState() {
		return curPendingProjState;
	}
	public void setCurPendingProjState(String curPendingProjState) {
		String oldVal = this.curPendingProjState;
		this.curPendingProjState = curPendingProjState;
		pcs.firePropertyChange("curPendingProjStatus", oldVal, curPendingProjState);
	}
	public Boolean getUpdatePlanStatus() {
		return updatePlanStatus;
	}
	public void setUpdatePlanStatus(Boolean updatePlanStatus) {
		this.updatePlanStatus = updatePlanStatus;
	}
	public Boolean getAriaSendStatus() {
		return ariaSendStatus;
	}
	public void setAriaSendStatus(Boolean ariaSendStatus) {
		this.ariaSendStatus = ariaSendStatus;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
	}
	public Boolean getReprocessStatus() {
		return reprocessStatus;
	}
	public void setReprocessStatus(Boolean reprocessStatus) {
		this.reprocessStatus = reprocessStatus;
	}
}
