package com.merrillcorp.enterprise.canonical.models;

import org.mule.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BilledParty implements Serializable {
	private static Logger logger = LoggerFactory.getLogger(BilledParty.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 7316436160280314592L;
	private BilledPartySourceData sourceData;
	private BillingSystemAccount billingSystemAccount;
	private BillingSystemAccount toBeBillingSystemAccount;
	private BilledPartyDirective billedPartyDirective;
	private String billingSystemMasterPlanInstanceId;
	private String billingSystemAccountId;
	private List<SuppField> suppFields;
	
	private String wrapInCDATA(String inString){
		return "<![CDATA[" + inString + "]]>";
	}

	/**
	 * Called by createCanonicalModel per billedParty, see if this can be removed
	 * @param projectCrossRefs
	 */
	public void setBillingSystemMasterPlanInstanceId(ProjectSourceData projectSourceData, List<CrossRef> projectCrossRefs){
		if(StringUtils.isEmpty(this.getBillingSystemAccountId(projectSourceData))){
			this.setBillingSystemMasterPlanInstanceId("");
		}
		else{
			for(CrossRef xref : projectCrossRefs){
				if(xref.getIdentifierTypeKey().equals("Aria_MPI") && xref.getQualifier1Value().equals(this.getBillingSystemAccountId(projectSourceData))){
					this.setBillingSystemMasterPlanInstanceId(xref.getIdentifierValue());
					break;
				}
				else{
					this.setBillingSystemMasterPlanInstanceId("");
				}
			}
		}
	}
	
	public List<String> getSplitSuppFields(int splitSize){
	    // Give the list the right capacity to start with. You could use an array
	    // instead if you wanted.
	    String text = "";
	    for(SuppField sp : suppFields){
	    	if(sp.getSuppFieldName().equals("INVOICE_TERM_VERBIAGE") || sp.getSuppFieldName().equals("INVOICE_FOOTER_NOTE") 
	    			|| sp.getSuppFieldName().equals("INVOICE_FOOTER_LEFT")
	    			|| sp.getSuppFieldName().equals("INVOICE_FOOTER_RIGHT") || sp.getSuppFieldName().equals("INVOICE_HEADER_LEFT")
	    			|| sp.getSuppFieldName().equals("INVOICE_HEADER_RIGHT")){
	    		text += "{ supp_field_name: " + sp.getSuppFieldName() + " supp_field_value: "+ this.wrapInCDATA(sp.getSuppFieldValue()) + "}";
	    	}
	    	else{
	    		text += "{ supp_field_name: " + sp.getSuppFieldName() + " supp_field_value: "+ sp.getSuppFieldValue() + "}";
	    	}
	    }
		List<String> ret = new ArrayList<String>((text.length() + splitSize - 1) / splitSize);

	    for (int start = 0; start < text.length(); start += splitSize) {
	        ret.add(text.substring(start, Math.min(text.length(), start + splitSize)));
	    }
	    return ret;
	}
	
	public List<SuppField> getSuppFields() {
		return suppFields;
	}

	public void setSuppFields(List<SuppField> suppFields) {
		this.suppFields = suppFields;
	}

	public void setBilledPartyDirectives(ProjectSourceData projectSourceData){
		if (StringUtils.isNotEmpty(this.billingSystemMasterPlanInstanceId))
	    	this.billedPartyDirective.setBilledPartyOperation(BilledPartyOperation.UPDATE);
		else
			this.billedPartyDirective.setBilledPartyOperation(BilledPartyOperation.ADD);

		if(this.isNewAccount(projectSourceData).equals(Boolean.FALSE)){
			if(!projectSourceData.getCurrency().equalsIgnoreCase(this.getCurrency(this.getBillingSystemAccountId(projectSourceData), projectSourceData)) ){
				this.getBilledPartyDirective().setIsCurrencyDifferent(Boolean.TRUE);
			}
			if(!projectSourceData.getLegalEntity().equalsIgnoreCase(this.getLegalEntity(this.getBillingSystemAccountId(projectSourceData), projectSourceData)))
				this.getBilledPartyDirective().setIsLegalEntityDifferent(Boolean.TRUE);
			
		}
		
	}

    public void determineBillToWorkflow(ProjectDirective projectDirective) { 
      if(projectDirective.getFlowType().equals(ProjectFlowType.UPDATESINGLE) && this.getBillingSystemMasterPlanInstanceId().equals("")){
    	  this.getBilledPartyDirective().setBillToWorkFlow(Boolean.TRUE);
    	  this.getBilledPartyDirective().setBillToWorkFlowTermination(Boolean.TRUE);
      }
      else if(this.getSourceData().getRetroChange()
    		  && (!this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getBillingAddressIds().equals(this.getSourceData().getBillingAddress().getOracleSiteId()))){
    	  this.getBilledPartyDirective().setBillToWorkFlow(Boolean.TRUE);
      }
      else if(this.getSourceData().getRetroChange() && this.determineContactDifference()){
    	  this.getBilledPartyDirective().setBillToWorkFlow(Boolean.TRUE);
      }
    } 
     
    public Boolean determineContactDifference () { 
      BillingSystemContact bsc = this.getBillingSystemAccount().getContacts().get(0); 
      BillingSystemContact tbsc = this.getToBeBillingSystemAccount().getContacts().get(0); 
      if(!bsc.getFirstName().equalsIgnoreCase(tbsc.getFirstName())){ 
        return Boolean.TRUE; 
      } 
      else if (!bsc.getLastName().equalsIgnoreCase(tbsc.getLastName())){ 
        return Boolean.TRUE; 
      } 
      else if (!bsc.getEmail().equalsIgnoreCase(tbsc.getEmail())){ 
        return Boolean.TRUE; 
      } 
      return Boolean.FALSE; 
    } 

	public Boolean isNewAccount(ProjectSourceData projectSourceData){

		Boolean result = Boolean.FALSE;

		if(this.getBillingSystemAccountId(projectSourceData).equals("NEW"))
			return Boolean.TRUE;
		else{
			for(CrossRef xref : this.getSourceData().getCrossRefs()){
				if (xref.getIdentifierTypeKey().equals("Aria_Acct")){
					if(projectSourceData.getCurrency().equals(xref.getQualifier1Value()) && projectSourceData.getLegalEntity().equals(xref.getQualifier2Value())){
						return Boolean.FALSE;
					}
				}
				else
					result = Boolean.TRUE;
			}
		}
		return result;
	}
	
	public String getBillingSystemMasterPlanInstanceId() {
		return billingSystemMasterPlanInstanceId;
	}
	
	public String getBillingSystemAccountId(ProjectSourceData projectSourceData) {
		//TODO FIXME This isn't sufficient for when multiple currencies are in affect.
		//i.e. This BilledParty could be on many projects. We need to find the
		//currency and legalEnt to use for the Project
		List<CrossRef> filtered = this.getSourceData().getCrossRefs().stream()
			.filter(i -> i.getIdentifierTypeKey().contains("Aria_Acct") && i.getQualifier1Value().equals(projectSourceData.getCurrency()) && i.getQualifier2Value().equals(projectSourceData.getLegalEntity()))
			.collect(Collectors.toList());
		if(filtered.isEmpty())
			return "NEW";
		else
		{
			return filtered.get(0).getIdentifierValue();
		}
	}
	
	public String getCurrency(String ariaAccountId, ProjectSourceData projectSourceData){
		CrossRef filtered = this.getSourceData().getCrossRefs().stream()
				.filter(i -> "Aria_Acct".equals(i.getIdentifierTypeKey()) && ariaAccountId.equals(i.getIdentifierValue())) 
				.findAny()
				.orElse(null);

		if(filtered != null && filtered.getQualifier1Key().equals("CURRENCY"))
			return filtered.getQualifier1Value();
		else
			return projectSourceData.getCurrency();
	}
	
	public String getLegalEntity(String ariaAccountId, ProjectSourceData projectSourceData){
		CrossRef filtered = this.getSourceData().getCrossRefs().stream()
				.filter(i -> "Aria_Acct".equals(i.getIdentifierTypeKey()) && ariaAccountId.equals(i.getIdentifierValue())) 
				.findAny()
				.orElse(null);

		if(filtered!=(null) && filtered.getQualifier2Key().equals("LEGALENT"))
			return filtered.getQualifier2Value();
		else
			return projectSourceData.getLegalEntity();
	}
	
	public String getBillingSystemMasterPlanId() {
		return billingSystemMasterPlanInstanceId;
	}

	//TODO We have two of these methods, but will probably only need one. Tests can call either.
	public void setBillingSystemMasterPlanInstanceId(String billingSystemMasterPlanInstanceId) {
		this.billingSystemMasterPlanInstanceId = billingSystemMasterPlanInstanceId;
	}

	public BilledParty(){
		this.sourceData = new BilledPartySourceData();
		this.billingSystemAccount = new BillingSystemAccount();
		this.toBeBillingSystemAccount = new BillingSystemAccount();
		this.billedPartyDirective = new BilledPartyDirective();
		this.suppFields = new ArrayList<SuppField>();
	}
	
	public Boolean dateCompare(String dateString1, String dateString2){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date1 = sdf.parse(dateString1);
			Date date2 = sdf.parse(dateString2);
			
			if(date1.before(date2)){
				return Boolean.TRUE;
			}
			else{
				return Boolean.FALSE;
			}
			}
		catch (ParseException e) {
			return Boolean.FALSE;
		}
	}
	
	public void determineActiveLabel(ProjectSourceData projectSourceData){
		if(this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getPlanInstanceStatus() == null || projectSourceData.getProjectStatus().equalsIgnoreCase(ProjectStatus.ACTIVE.projectStatus()) != true) {
			this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setActiveLabel(" ");
		}
		else if (projectSourceData.getProjectStatus().equalsIgnoreCase(ProjectStatus.ACTIVE.projectStatus())
				&& (projectSourceData.getBillingEffectiveDate().equals("")
						|| this.dateCompare(projectSourceData.getActiveDate(), projectSourceData.getBillingEffectiveDate()))) {
			this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setActiveLabel("Launched");
		}
		else{
			this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setActiveLabel("Effective");
		}
	}
	
	public void setSuspendedDate(ProjectSourceData projectSourceData){
		if (projectSourceData.getProjectStatus().equalsIgnoreCase(ProjectStatus.SUSPENDED.projectStatus()))
			{DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date currentDate=new Date();
			this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setSuspendedDate(dateFormat.format(currentDate));}
		else
		{this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setSuspendedDate("");
		
		}	
	}
	
	public void setCloseDate(ProjectSourceData projectSourceData){
        if (projectSourceData.getProjectStatus().equalsIgnoreCase(ProjectStatus.CLOSED.projectStatus()))
            {DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate=new Date();
            this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setCloseDate(dateFormat.format(currentDate));}
        else
        {this.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setCloseDate("");
        
        }    
    }
	
	public void updateToBeAriaAccounts(String ariaAcctId, String ariaMPI){
		this.getToBeBillingSystemAccount().setBillingSystemAccountId(ariaAcctId);
		this.getToBeBillingSystemAccount().setBillingSystemMasterPlanId(ariaMPI);
	}
	
	public BillingSystemAccount getBillingSystemAccount() {
		return billingSystemAccount;
	}
	public void setBillingSystemAccount(BillingSystemAccount billingSystemAccount) {
		this.billingSystemAccount = billingSystemAccount;
	}
	public BillingSystemAccount getToBeBillingSystemAccount() {
		return toBeBillingSystemAccount;
	}
	public void setToBeBillingSystemAccount(BillingSystemAccount toBeBillingSystemAccount) {
		this.toBeBillingSystemAccount = toBeBillingSystemAccount;
	}
	public BilledPartyDirective getBilledPartyDirective() {
		return billedPartyDirective;
	}
	public void setBilledPartyDirective(BilledPartyDirective billedPartyDirective) {
		this.billedPartyDirective = billedPartyDirective;
	}
	
	public BilledPartySourceData getSourceData() {
		return sourceData;
	}
	public void setSourceData(BilledPartySourceData sourceData) {
		this.sourceData = sourceData;
	}

	public String getBillingSystemAccountId() {
		return billingSystemAccountId;
	}

	public void setBillingSystemAccountId(String billingSystemAccountId) {
		this.billingSystemAccountId = billingSystemAccountId;
	}
}
