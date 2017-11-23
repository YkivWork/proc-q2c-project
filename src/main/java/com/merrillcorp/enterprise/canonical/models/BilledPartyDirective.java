package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class BilledPartyDirective implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1542150047346684322L;
	private String ariaAcctNo;
	private Boolean isExistingAccount=Boolean.FALSE;
	private BilledPartyOperation billedPartyOperation;
	private Boolean billToWorkFlow=Boolean.FALSE;
	private Boolean billToWorkFlowTermination=Boolean.FALSE;
	private Boolean isCurrencyDifferent = Boolean.FALSE;
	private Boolean isLegalEntityDifferent = Boolean.FALSE;
	private Boolean reprocessStatus = Boolean.FALSE;
	
	
	public BilledPartyOperation getBilledPartyOperation() {
		return billedPartyOperation;
	}
	public void setBilledPartyOperation(BilledPartyOperation billedPartyOperation) {
		this.billedPartyOperation = billedPartyOperation;
	}
	public Boolean getBillToWorkFlow() {
		return billToWorkFlow;
	}
	public void setBillToWorkFlow(Boolean billToWorkFlow) {
		this.billToWorkFlow = billToWorkFlow;
	}
	public Boolean getIsCurrencyDifferent() {
		return isCurrencyDifferent;
	}
	public void setIsCurrencyDifferent(Boolean isCurrencyDifferent) {
		this.isCurrencyDifferent = isCurrencyDifferent;
	}
	public Boolean getIsLegalEntityDifferent() {
		return isLegalEntityDifferent;
	}
	public void setIsLegalEntityDifferent(Boolean isLegalEntityDifferent) {
		this.isLegalEntityDifferent = isLegalEntityDifferent;
	}
	public Boolean getIsExistingAccount() {
		return isExistingAccount;
	}
	public void setIsExistingAccount(Boolean isExistingAccount) {
		this.isExistingAccount = isExistingAccount;
	}
	public String getAriaAcctNo() {
		return ariaAcctNo;
	}
	public void setAriaAcctNo(String ariaAcctNo) {
		this.ariaAcctNo = ariaAcctNo;
	}
	public Boolean getBillToWorkFlowTermination() {
		return billToWorkFlowTermination;
	}
	public void setBillToWorkFlowTermination(Boolean billToWorkFlowTermination) {
		this.billToWorkFlowTermination = billToWorkFlowTermination;
	}
}
