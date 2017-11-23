package com.merrillcorp.enterprise.canonical.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.merrillcorp.enterprise.utilities.DateUtilities;

/**
 * <h1>Root Q2C Canonical Model Project Object</h1>
 * @author podo-crennert
 *
 */
public class Project implements Serializable {
	private static Logger logger = LoggerFactory.getLogger(Project.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -4651592857875352145L;
	private List<CrossRef> crossRefs;
	private List<Entitlement> entitlements;
	private List<BilledParty> billedParties;
	private ProjectDirective projectDirective;
	private ProjectSourceData sourceData;
	private IntegrationMetadata integrationMetadata;
	private String specialMediaRateAssigned;
	
	
	private PropertyChangeListener projSourceDataListener = new PropertyChangeListener(){
	      public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
	          String property = propertyChangeEvent.getPropertyName();
	          if(property.equals("projectStatus")){
	        	  processProjectStatusChange();
	          }
	          else if(property.equals("unitOfMeasure")){
	        	  processUnitOfMeasureChange();
	          }
	          else if(property.equals("continuationDate")){
	        	  processContinuationDateChange();
	          }

          }
	};
	
	private PropertyChangeListener projDirectiveListener = new PropertyChangeListener(){
		public void propertyChange(PropertyChangeEvent propertyChangeEvent){
			String property = propertyChangeEvent.getPropertyName();
			if(property.equals("fromProjState")){
				processFromProjStateChange();
				
			}
			else if(property.equals("toProjState")){
				processToProjStateChange();
			}
			else if(property.equals("curPendingProjState")){
				processCurPendingProjStateChange();
			}
		}
	};
	
	private void processProjectStatusChange(){
		
	}
	
	private void processUnitOfMeasureChange(){
		
	}
	
	private void processContinuationDateChange(){
		
	}
	
	private void processToProjStateChange(){
		
	}
	
	/**
	 * @author Rennert Chris
	 * @since 2017-10-02
	 * @return Nothing
	 */
	private void processCurPendingProjStateChange(){
		
	}
	
	/**
	 * <h1>Process From Project State Change</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @return Nothing
	 */
	private void processFromProjStateChange(){
		if (getProjectDirective().getFromProjState().equals(ProjectStatus.HIBERNATION.projectStatus()) 
				&& !getProjectDirective().getToProjState().equals(getSourceData().isInContinuation())){
			zeroHostedRates();
			
		}
		
		//Set Hibernate Out Date
		this.processHibernateOutDate();
			
	}
	
	
	private void processHibernateOutDate(){
		if(getProjectDirective().getFromProjState().equals(ProjectStatus.HIBERNATION.projectStatus())
				&& !getProjectDirective().getToProjState().equals(ProjectStatus.HIBERNATION.projectStatus())){
			
			this.getBilledParties().forEach(x -> { 
				if(x.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getHibernateOutDate() == null){
					x.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().setHibernateOutDate(DateUtilities.getFormatedDate(new Date()));
					x.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().setHibernateOutDateDirective("1");
				}
				else{
					x.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().setHibernateOutDateDirective("2");
					x.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().setHibernateOutDate(DateUtilities.getFormatedDate(new Date()));
				}
			});
		}
		else if((getProjectDirective().getFromProjState().equals(ProjectStatus.HIBERNATION.projectStatus())
				&& getProjectDirective().getToProjState().equals(ProjectStatus.HIBERNATION.projectStatus())) 
				|| (!getProjectDirective().getFromProjState().equals(ProjectStatus.HIBERNATION.projectStatus()))){
			this.getBilledParties().forEach(x -> { 
				x.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().setHibernateOutDateDirective("2");
			});
		}

	}
	
	/**
	 * <h1>Zero Out Hosted Rates</h1>
	 * ZeroOutHostedRates zeros hosted rates for GBs_Hosted, MBs_Hosted, Pages_Hosted, and Special_Media_Hosted Client Plan Ids
	 * @author podo-crennert
	 * @return Nothing
	 * @since 2017-10-02
	 */
	private void zeroHostedRates(){
		for(BilledParty bp : this.getBilledParties()){
			bp.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getSuppPlans().forEach(x -> {
				if(x.getClientPlanId().equals("GBs_Hosted") || x.getClientPlanId().equals("MBs_Hosted") 
						|| x.getClientPlanId().equals("Pages_Hosted") || x.getClientPlanId().equals("Special_Media_Hosted")){
					x.getCustomRates().forEach(y -> y.setCustomRatePerUnit("0"));
				}
			});
		}
	}
	
	public void setSpecialMediaRateAssigned(String specialMediaRateAssigned) {
		this.specialMediaRateAssigned = specialMediaRateAssigned;
	}

	/**
	 * <h1>Project Constructor</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 */
	public Project(){
		this.crossRefs = new ArrayList<CrossRef>();
		this.entitlements = new ArrayList<Entitlement>();
		this.billedParties = new ArrayList<BilledParty>();
		this.projectDirective = new ProjectDirective();
		this.sourceData = new ProjectSourceData();
		this.integrationMetadata = new IntegrationMetadata();
		this.sourceData.addPropertyChangeListener(projSourceDataListener);
		this.projectDirective.addPropertyChangeListener(projDirectiveListener);
	}
	
	public IntegrationMetadata getIntegrationMetadata() {
		return integrationMetadata;
	}

	public void setIntegrationMetadata(IntegrationMetadata integrationMetadata) {
		this.integrationMetadata = integrationMetadata;
	}

	public ProjectSourceData getSourceData() {
		return sourceData;
	}

	public void setSourceData(ProjectSourceData sourceData) {
		this.sourceData = sourceData;
	}

	public ProjectDirective getProjectDirective(){
		return this.projectDirective;
	}
	
	public void setProjectDirective(ProjectDirective projectDirective) {
		this.projectDirective = projectDirective;
	}
	
	public List<CrossRef> getCrossRefs() {
		return crossRefs;
	}
	public void setCrossRefs(List<CrossRef> crossRefs) {
		this.crossRefs = crossRefs;
	}
	public List<Entitlement> getEntitlements() {
		return entitlements;
	}
	
	/**
	 * <h1>Get Current Entitlements</h1>
	 * Returns a String Representation of Entitlements, based on Project Status
	 * @author podo-crennert
	 * @since 2017-10-02
	 * @return String representation of Active Entitlements
	 */
	private String getCurrentEntitlement(){
	  switch(this.getSourceData().getProjectStatus()){
	  	case "Active":
		  return this.getEntitlements().get(0).getActiveEntitlements();
	  	case "Hibernation":
	  		return this.getEntitlements().get(0).getHibernationEntitlements();
	  	case "Suspended":
	  		return this.getEntitlements().get(0).getSuspendedEntitlements();
	  	case "Build Period":
	  		return this.getEntitlements().get(0).getPreparationEntitlements();
	  	case "Closure_Requested":
	  		return this.getEntitlements().get(0).getPendingCloseEntitlements();
	  	case "Closed":
	  		return this.getEntitlements().get(0).getPendingCloseEntitlements();
	  	case "Active with Continuation":
	  		return this.getEntitlements().get(0).getActiveEntitlements();
	  	default:
	  		return "";
		  
	  }
	}
	
	/**
	 * <h1>Set Entitlements</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @param entitlements
	 * @return Nothing
	 */
	public void setEntitlements(List<Entitlement> entitlements) {
		this.entitlements = entitlements;
		for(BilledParty bp : this.getBilledParties()){
			String ent = this.getCurrentEntitlement();
			bp.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().setCurrentEntitlement(ent);
		}
	}
	
	public List<BilledParty> getBilledParties() {
		return billedParties;
	}
	
	public void setBilledParties(List<BilledParty> billedParties) {
		this.billedParties = billedParties;
	}
	
	/**
	 * <h1>Set Project Directives</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @return Nothing
	 */
	public void setProjectDirectives(){
		
		//this.determineAriaSendStatus();
		
		this.getProjectDirective().setNewToAria(this.getAriaMPICount() < 1);
		this.getProjectDirective().setSplitBill(this.getAriaMPICount() > 1);
		this.getProjectDirective().setUpdatePlanStatus(this.determineUpdatePlanStatus());
		String MPIcount =this.getAriaMPICount().toString();
		
		//Project State Directives  
	    this.getProjectDirective().setToProjState(this.getSourceData().getProjectStatus()); 
	    if (this.getIntegrationMetadata().getLastCompletedProjectStatus() != null) {
	    	this.getProjectDirective().setFromProjState(this.getIntegrationMetadata().getLastCompletedProjectStatus());	
		}
	    this.getProjectDirective().setCurPendingProjState(this.getIntegrationMetadata().getPendingStatusChange());
		
		//Set Project Flow Type
		if(this.getProjectDirective().getNewToAria() && this.getProjectDirective().getSplitBill().equals(Boolean.FALSE) ){
			this.getProjectDirective().setFlowType(ProjectFlowType.NEWSINGLE);
		}
		else if(this.getProjectDirective().getUpdatePlanStatus()) {
			this.getProjectDirective().setFlowType(ProjectFlowType.UPDATEPLANSTATUS);
		}
		else if(this.getProjectDirective().getNewToAria() == Boolean.FALSE && this.getProjectDirective().getSplitBill().equals(Boolean.FALSE)){
			this.getProjectDirective().setFlowType(ProjectFlowType.UPDATESINGLE);
			this.getProjectDirective().setProrationNeeded(this.determineProrationNeeded());
		}
		else if(this.getProjectDirective().getNewToAria() && this.getProjectDirective().getSplitBill() ){
			this.getProjectDirective().setFlowType(ProjectFlowType.NEWSPLIT);
		}
		else if(this.getProjectDirective().getNewToAria().equals(Boolean.FALSE) && this.getProjectDirective().getSplitBill()){
			this.getProjectDirective().setFlowType(ProjectFlowType.UPDATESPLIT);
			this.getProjectDirective().setProrationNeeded(this.determineProrationNeeded());
		}
		
		//DSO Project Directives
		this.getProjectDirective().setCreateDSO(this.dsoXrefExists() && !this.getSourceData().getProjectSfdcId().equals(""));
		this.getProjectDirective().setUpdateDSO(this.dsoXrefExists().equals(Boolean.FALSE) && this.getSourceData().getProjectSfdcId().isEmpty());
		this.getProjectDirective().setIsManualDataRoom(this.dsoXrefExists().equals(Boolean.FALSE) && !this.getSourceData().getProjectSfdcId().equals(""));
  
	      
	      this.determineProjectStatusValue();
	}
	
	/**
	 * <h1>Determine Update Plan Status</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @return Boolean - Update Plan Status
	 */
	public Boolean determineUpdatePlanStatus() {
		if("true".equals(this.getSourceData().getUpdatePlanStatus())){
			return Boolean.TRUE;
		}

        return Boolean.FALSE;
	}
	
	
	private Boolean dsoXrefExists(){
		List<CrossRef> filtered = this.getCrossRefs().stream()
				.filter(i -> i.getIdentifierTypeKey().contains("DS1_Proj") && i.getEntityTypeKey().contains("PROJ"))
				.collect(Collectors.toList());
		if(filtered.isEmpty())
			return Boolean.FALSE;
		else
			return Boolean.TRUE;		
	}
	private Boolean ariaAcctXrefExists(){
		List<CrossRef> filtered = this.getCrossRefs().stream()
				.filter(i -> i.getIdentifierTypeKey().contains("Aria_Acct") && i.getEntityTypeKey().contains("PROJ"))
				.collect(Collectors.toList());
		if(filtered.isEmpty())
			return Boolean.FALSE;
		else
			return Boolean.TRUE;		
	}
	private Boolean ariaMpiXrefExists(){
		List<CrossRef> filtered = this.getCrossRefs().stream()
				.filter(i -> i.getIdentifierTypeKey().contains("Aria_MPI") && i.getEntityTypeKey().contains("PROJ"))
				.collect(Collectors.toList());
		if(filtered.isEmpty())
			return Boolean.FALSE;
		else
			return Boolean.TRUE;		
	}
	
	/**
	 * <h1>Get Aria MPI Count</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @return Integer - Aria Master Plan Instance Count
	 */
	private Integer getAriaMPICount(){
        List<CrossRef> filtered = this.getCrossRefs().stream()
                .filter(i -> i.getIdentifierTypeKey().contains("Aria_MPI"))
                .collect(Collectors.toList());
            if(filtered.isEmpty())
                return 0;
            else
            {
                return filtered.size();            
            }
        /*CrossRef xref = new CrossRef() {{ setIdentifierTypeKey("Aria_MPI"); }};
        return Collections.frequency(this.getCrossRefs(), xref);*/
    }
	
	/**
	 * <h1>Trim to Three</h1>
	 * Utility function to trim a string down to 3 characters.
	 * @author podo-crennert
	 * @since 2017-10-03
	 * @param stringToTrim
	 * @return String - First three characters stringToTrim
	 */
	private String trimToThree(String stringToTrim){
		if(stringToTrim.length() > 2)
			return stringToTrim.substring(0,3);
		else 
			return stringToTrim;
	}
	
	/**
	 * <h1>Host Label Blank or Null</h1>
	 * @param billedParty
	 * @return Boolean - Hosting Label Blank or Null
	 */
	private Boolean hostingLabelBlankOrNull(BilledParty billedParty){
		if (billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().hostingLabelBlankOrNull()){
			return Boolean.TRUE;
		}
		else
			return Boolean.FALSE;
	}
	
	
	private SuppPlanInstanceField getHostingLabel(BilledParty billedParty){
		SuppPlanInstanceField pi = new SuppPlanInstanceField();
		String directive;
		if(this.hostingLabelBlankOrNull(billedParty))
			directive = "1";
		else 
			directive = "2";
		
		pi.setPlanInstanceFieldName("HOSTING_LABEL");
		if(this.getSourceData().isBilledByHosted()){
			if(this.getSourceData().isInContinuation()){
				pi.setPlanInstanceFieldValue("In Continuation");
				pi.setPlanInstanceFieldDirective(directive);
			}
			else if(this.getSourceData().isHibernation()){
				pi.setPlanInstanceFieldValue("In Hibernation");
				pi.setPlanInstanceFieldDirective(directive);
			}
		}
		else{
			pi.setPlanInstanceFieldName("HOSTING_LABEL");
			pi.setPlanInstanceFieldDirective(directive);
			

		}
		return pi;
	}
	
	private List<BillingSystemSuppPlanInstance> generateStaticSuppPlans(BilledParty billedParty) {
		List<BillingSystemSuppPlanInstance> suppList = new ArrayList<BillingSystemSuppPlanInstance>();
		Project project = this;
		BillingSystemSuppPlanInstance suppPlan = null;

		//Special Media
		suppPlan = new BillingSystemSuppPlanInstance();
		suppPlan.setClientPlanId("Special_Media");
		suppPlan.setSuppPlanInstanceStatusCd(this.getAriaSuppPlanStatusValue());
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("SMUploaded"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite()));  }});
		suppPlan.getCustomRates().add(new CustomRate(){{ setCustomRateClientServiceId("SMUploaded"); setCustomRateSequenceNumber("1"); setCustomRateFromUnit(1.0); setCustomRatePerUnit(project.getSourceData().getSpecialMediaRate()); }} );
		suppPlan.setUsageAccumulationResetMonths(99);
		suppList.add(suppPlan);

		//Pages Uploaded
		suppPlan = new BillingSystemSuppPlanInstance();
		suppPlan.setClientPlanId("Pages_Uploaded");
		suppPlan.setSuppPlanInstanceStatusCd(this.getAriaSuppPlanStatusValue());
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("PgUploaded"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("PgMinimumFee"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});		
		suppPlan.setUsageAccumulationResetMonths(99);	
		suppList.add(suppPlan);

		//MBs Uploaded
		suppPlan = new BillingSystemSuppPlanInstance();
		suppPlan.setClientPlanId("MBs_Uploaded");
		suppPlan.setSuppPlanInstanceStatusCd(this.getAriaSuppPlanStatusValue());
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("MBUploaded"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("MBMinimumFee"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});		
		suppPlan.setUsageAccumulationResetMonths(99);		
		suppList.add(suppPlan);

		//GBs Uploaded
		suppPlan = new BillingSystemSuppPlanInstance();
		suppPlan.setClientPlanId("GBs_Uploaded");
		suppPlan.setSuppPlanInstanceStatusCd(this.getAriaSuppPlanStatusValue());
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("GBUploaded"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("GBMinimumFee"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});		
		suppPlan.setUsageAccumulationResetMonths(99);		
		suppList.add(suppPlan);

		//Pages Hosted
		suppPlan = new BillingSystemSuppPlanInstance();
		suppPlan.setClientPlanId("Pages_Hosted");
		suppPlan.setSuppPlanInstanceStatusCd(this.getAriaSuppPlanStatusValue());
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("PgHosted"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});
		suppPlan.setUsageAccumulationResetMonths(99);
		suppPlan.setSuppPlanInstanceField(this.getHostingLabel(billedParty));
		suppList.add(suppPlan);

		//MBs Hosted
		suppPlan = new BillingSystemSuppPlanInstance();
		suppPlan.setClientPlanId("MBs_Hosted");
		suppPlan.setSuppPlanInstanceStatusCd(this.getAriaSuppPlanStatusValue());
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("MBHosted"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});
		suppPlan.setUsageAccumulationResetMonths(99);		
		suppPlan.setSuppPlanInstanceField(this.getHostingLabel(billedParty));


		suppList.add(suppPlan);

		//GBs Hosted
		suppPlan = new BillingSystemSuppPlanInstance();
		suppPlan.setClientPlanId("GBs_Hosted");
		suppPlan.setSuppPlanInstanceStatusCd(this.getAriaSuppPlanStatusValue());
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("GBHosted"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});
		suppPlan.setUsageAccumulationResetMonths(99);		
		suppPlan.setSuppPlanInstanceField(this.getHostingLabel(billedParty));
		suppList.add(suppPlan);

		//Special Media Hosted
		suppPlan = new BillingSystemSuppPlanInstance();
		suppPlan.setClientPlanId("Special_Media_Hosted");
		suppPlan.setSuppPlanInstanceStatusCd(this.getAriaSuppPlanStatusValue());
		suppPlan.getSuppPlanServices().add(new SuppPlanServiceItem() {{ setClientServiceId("SMHosted"); setClientServiceLocationId(project.trimToThree(project.getSourceData().getRevenueSite())); }});
		suppPlan.setUsageAccumulationResetMonths(99);		
		suppList.add(suppPlan);		

		return suppList;
	}

	public List<CustomRate> generateCustomRates() {
		List<CustomRate> customRateList = new ArrayList<CustomRate>();
		CustomRate cr = new CustomRate();
		cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceNameMinimumFee());
		cr.setCustomRateSequenceNumber("1");
		cr.setCustomRateFromUnit(1.0);
		cr.setCustomRatePerUnit(this.getSourceData().getMinimumFee());
		customRateList.add(cr);
		if(this.getSourceData().getTier1Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier1Rate().toString());
			cr.setCustomRateSequenceNumber("1");
			cr.setCustomRateToUnit(this.getSourceData().getTier1UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier2Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier1UpperLimit() + 1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier2Rate().toString());
			cr.setCustomRateSequenceNumber("2");
			cr.setCustomRateToUnit(this.getSourceData().getTier2UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier3Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier2UpperLimit() + 1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier3Rate().toString());
			cr.setCustomRateSequenceNumber("3");
			cr.setCustomRateToUnit(this.getSourceData().getTier3UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier4Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier3UpperLimit() + 1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier4Rate().toString());
			cr.setCustomRateSequenceNumber("4");
			cr.setCustomRateToUnit(this.getSourceData().getTier4UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier5Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier4UpperLimit()+1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier5Rate().toString());
			cr.setCustomRateSequenceNumber("5");
			cr.setCustomRateToUnit(this.getSourceData().getTier5UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier6Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier5UpperLimit() + 1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier6Rate().toString());
			cr.setCustomRateSequenceNumber("6");
			cr.setCustomRateToUnit(this.getSourceData().getTier6UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier7Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier6UpperLimit() + 1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier7Rate().toString());
			cr.setCustomRateSequenceNumber("7");
			cr.setCustomRateToUnit(this.getSourceData().getTier7UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier8Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier7UpperLimit() + 1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier8Rate().toString());
			cr.setCustomRateSequenceNumber("8");
			cr.setCustomRateToUnit(this.getSourceData().getTier8UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier9Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier8UpperLimit() + 1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier9Rate().toString());
			cr.setCustomRateSequenceNumber("9");
			cr.setCustomRateToUnit(this.getSourceData().getTier9UpperLimit());
			customRateList.add(cr);
		}
		if(this.getSourceData().getTier10Rate()!= null){
			cr = new CustomRate();
			cr.setCustomRateClientServiceId(this.getSourceData().getClientServiceName());
			cr.setCustomRateFromUnit(this.getSourceData().getTier9UpperLimit() + 1.0);
			cr.setCustomRatePerUnit(this.getSourceData().getTier10Rate().toString());
			cr.setCustomRateSequenceNumber("10");
			//cr.setCustomRateToUnit(this.getSourceData().getTier10UpperLimit());
			customRateList.add(cr);
		}
		return customRateList;
	}

	private BillingSystemContact populateToBeBillingSystemContact(BilledParty billedParty) {
		BillingSystemContact contact = new BillingSystemContact() {{
			setFirstName(billedParty.getSourceData().getBillingAddress().getFirstName());
			setLastName(billedParty.getSourceData().getBillingAddress().getLastName());
			setCompanyName(billedParty.getSourceData().getBillingCompany().getName());
			setAddress1(billedParty.getSourceData().getBillingAddress().getAddress1());
			setAddress2(billedParty.getSourceData().getBillingAddress().getAddress2());
			setAddress3(billedParty.getSourceData().getBillingAddress().getAddress3());
			setCity(billedParty.getSourceData().getBillingAddress().getCity());
			setLocality(billedParty.getSourceData().getBillingAddress().getLocality());
			setStateProvince(billedParty.getSourceData().getBillingAddress().getStateProvince());
			setPhone(billedParty.getSourceData().getBillingAddress().getPhone());
			setEmail(billedParty.getSourceData().getBillingAddress().getEmail());
			setCountry(billedParty.getSourceData().getBillingAddress().getCountry());
			setPostalCode(billedParty.getSourceData().getBillingAddress().getPostalCode());
		}};

		return contact;
	}

	private void initializeProperties(){
		this.getSourceData().isActive();
		this.getSourceData().isBilledByGBs();
		this.getSourceData().isBilledByGBsUploaded();
		this.getSourceData().hasMinimumFee();
		this.getSourceData().hibernateOrInContinuation();
		this.getSourceData().isBilledByGBsHosted();
		this.getSourceData().isBilledByHosted();
		this.getSourceData().isBilledByMBs();
		this.getSourceData().isBilledByMBsHosted();
		this.getSourceData().isBilledByMBsUploaded();
		this.getSourceData().isBilledByPages();
		this.getSourceData().isBilledByPagesHosted();
		this.getSourceData().isBilledByPagesUploaded();
		this.getSourceData().isBilledByUploaded();
		this.getSourceData().getHostingLabelValue();
		this.getSourceData().isHibernation();
		this.getSourceData().isInContinuation();
		this.getSpecialMediaRateAssigned();
	}
	
	public List<MasterPlanServiceItem> setDefaultClientServiceId(String revenueSite){
		MasterPlanServiceItem mpiItem = new MasterPlanServiceItem() {{
			setClientServiceLocationId(revenueSite);
		}};
		List<MasterPlanServiceItem> masterPlanServices = new ArrayList<MasterPlanServiceItem>();
		masterPlanServices.add(mpiItem);
		return masterPlanServices;
	}
	
	public String getBillingGroupName(BilledParty billedParty){
		//Old Method
		/*String billingGroupName = billedParty.getSourceData().getBillingCompany().getOracleAccountId() 
				+ "-" 
				+ billedParty.getSourceData().getBillingAddress().getOracleSiteId()
				+ "-"
				+ billedParty.getCurrency(billedParty.getBillingSystemAccountId(), this.getSourceData());*/
		return this.getSourceData().getProjectSfdcId();
	}

	/**
	 * Called in createCanonicalModel, after each billedParty is loaded from the billingSystem
	 */
	public void populateToBeBilledModel() {
		for(BilledParty bp : this.getBilledParties() ){
			bp.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().setSuppPlans(generateStaticSuppPlans(bp));

			for (BillingSystemSuppPlanInstance spi : bp.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getSuppPlans()) {
				spi.setCustomRates(this.generateCustomRatesForSuppPlan(spi));
				mapToBeSuppPlanFromAsIsSuppPlan(bp.getBillingSystemAccount().getBillingSystemMasterPlanInstance(), spi);
			}	

			//if(!this.getProjectDirective().getFlowType().equals(ProjectFlowType.NEWSINGLE))
			//bp.setToBeBillingSystemAccount((BillingSystemAccount)org.apache.commons.lang.SerializationUtils.clone(bp.getBillingSystemAccount()));
			//bp.setToBeBillingSystemAccount(bp.getBillingSystemAccount());

			this.populateToBeBilledParty(bp);
		}
	}

	private void mapToBeSuppPlanFromAsIsSuppPlan(BillingSystemMasterPlanInstance asIsMpi, BillingSystemSuppPlanInstance suppPlan){

		for (BillingSystemSuppPlanInstance asIsSuppPlan: asIsMpi.getSuppPlans()) {
		    if (asIsSuppPlan.getClientPlanId().equals(suppPlan.getClientPlanId())) {
		    	suppPlan.setClientSuppPlanInstanceId(asIsSuppPlan.getClientSuppPlanInstanceId());

		    	//TODO FIXME Should we also be setting getSuppPlanInstanceStatusCd here?
//				if(asIsSuppPlan.getSuppPlanInstanceStatusCd() != null)
//					suppPlan.setSuppPlanInstanceStatusCd(asIsSuppPlan.getSuppPlanInstanceStatusCd());
				if(asIsSuppPlan.getAltRateScheduleNumber() != null)
					suppPlan.setAltRateScheduleNumber(asIsSuppPlan.getAltRateScheduleNumber());
				if(asIsSuppPlan.getClientParentPlanInstanceId() != null)
					suppPlan.setClientParentPlanInstanceId(asIsSuppPlan.getClientParentPlanInstanceId());
				suppPlan.setLastArrearsBillThroughDate(asIsSuppPlan.getLastArrearsBillThroughDate());
				suppPlan.setLastBillDate(asIsSuppPlan.getLastBillDate());
				suppPlan.setLastBillThroughDate(asIsSuppPlan.getLastBillThroughDate());
				suppPlan.setNextBillDate(asIsSuppPlan.getNextBillDate());
				suppPlan.setParentPlanInstanceNumber(asIsSuppPlan.getParentPlanInstanceNumber());
				suppPlan.setPlanDate(asIsSuppPlan.getPlanDate());
				suppPlan.setPlanDeprovisionDate(asIsSuppPlan.getPlanDeprovisionDate());
				suppPlan.setPoNumber(asIsSuppPlan.getPoNumber());
				suppPlan.setRolloverPlanStatus(asIsSuppPlan.getRolloverPlanStatus());
				suppPlan.setRecurringBillingInterval(asIsSuppPlan.getRecurringBillingInterval());
				suppPlan.setRolloverPlanStatusDuration(asIsSuppPlan.getRolloverPlanStatusDuration());
				suppPlan.setRolloverPlanStatusUOMCd(asIsSuppPlan.getRolloverPlanStatusUOMCd());
				suppPlan.setStatusDate(asIsSuppPlan.getStatusDate());
				suppPlan.setSuppPlanInstanceDescription(asIsSuppPlan.getSuppPlanInstanceDescription());
				suppPlan.setSuppPlanInstanceNumber(asIsSuppPlan.getSuppPlanInstanceNumber());
				suppPlan.setSuppPlanInstanceStatus(asIsSuppPlan.getSuppPlanInstanceStatus());
//				suppPlan.setSuppPlanInstanceStatusCd(asIsSuppPlan.getSuppPlanInstanceStatusCd());
				suppPlan.setSuppPlanNumber(asIsSuppPlan.getSuppPlanNumber());
				suppPlan.setSuppPlanUnits(asIsSuppPlan.getSuppPlanUnits());
				suppPlan.setUsageAccumulationResetMonths(asIsSuppPlan.getUsageAccumulationResetMonths());
				suppPlan.setUsageBillingInterval(asIsSuppPlan.getUsageBillingInterval());
				suppPlan.setCustomRates(this.generateCustomRatesForSuppPlan(asIsSuppPlan));
				suppPlan.setSuppPlanServices(asIsSuppPlan.getSuppPlanServices());
				
		    	break;
			}
		}
	}
	
	private List<CustomRate> generateCustomRatesForUploaded(){
		return this.generateCustomRates();
	}
	private String getHostedRate(){
		String rate = "0";
		if(this.getSourceData().isHibernation()){  
			rate = this.getSourceData().getHibernationRate();  
		}
		else if(this.getSourceData().isInContinuation()){
			rate = this.getSourceData().getContinuationRate();
		}
		
		return rate;
	}
	private String getSpecialMediaHostedRate(){
		String rate = "0";
		if(this.getSourceData().isHibernation()){  
			rate = this.getSourceData().getHibernationRateSM();  
		}
		else if(this.getSourceData().isInContinuation()){
			rate = this.getSourceData().getContinuationRateSM();
		}
		
		return rate;	
	}
	
	private List<CustomRate> generateCustomRatesForHosted(String clientServiceId){
		List<CustomRate> cr =  new ArrayList<CustomRate>();

		CustomRate cRate = new CustomRate();
		cRate.setCustomRateClientServiceId(clientServiceId);
		cRate.setCustomRateSequenceNumber("1");
		cRate.setCustomRateFromUnit(1.0);
		String rate = this.getHostedRate(); 
		cRate.setCustomRatePerUnit(rate); 
		cr.add(cRate);
		return cr;
	}
	
	private List<CustomRate> generateCustomRatesForSpecialMedia(){
		List<CustomRate> cr =  new ArrayList<CustomRate>();
		CustomRate cRate = new CustomRate();
		cRate.setCustomRateClientServiceId("SMUploaded");
		cRate.setCustomRateSequenceNumber("1");
		cRate.setCustomRateFromUnit(1.0);
		String rate = this.getSourceData().getSpecialMediaRate(); 
		cRate.setCustomRatePerUnit(rate); 
		cr.add(cRate);
		return cr;
	}
	
	private List<CustomRate> generateCustomRateForSpecialMediaHosted(){
		List<CustomRate> cr = new ArrayList<CustomRate>();
		CustomRate cRate = new CustomRate();
		cRate.setCustomRateClientServiceId("SMHosted");
		cRate.setCustomRateSequenceNumber("1");
		cRate.setCustomRateFromUnit(1.0);
		String rate = this.getSpecialMediaHostedRate();
				//this.getSourceData().isHibernation() ? this.getSourceData().getHibernationRateSM() : this.getSourceData().getContinuationRateSM();
		cRate.setCustomRatePerUnit(rate);
		cr.add(cRate);
		return cr;
	}
	
	private CustomRate generateEmptyCustomRateGBUploaded(){
		CustomRate cr = new CustomRate();
		cr.setCustomRateClientServiceId("GBUploaded");
		cr.setCustomRateSequenceNumber("1");
		cr.setCustomRateFromUnit(1.0);
		cr.setCustomRatePerUnit("0");
		return cr;
	}
	
	private CustomRate generateEmptyCustomRateMBUploaded(){
		CustomRate cr = new CustomRate();
		cr.setCustomRateClientServiceId("MBUploaded");
		cr.setCustomRateSequenceNumber("1");
		cr.setCustomRateFromUnit(1.0);
		cr.setCustomRatePerUnit("0");
		return cr;
	}
	
	private CustomRate generateEmptyCustomRatePagesUploaded(){
		CustomRate cr = new CustomRate();
		cr.setCustomRateClientServiceId("PgUploaded");
		cr.setCustomRateSequenceNumber("1");
		cr.setCustomRateFromUnit(1.0);
		cr.setCustomRatePerUnit("0");
		return cr;
	}
	
	private CustomRate generateEmptyCustomRateGBHosted(){
		CustomRate cr = new CustomRate();
		cr.setCustomRateClientServiceId("GBHosted");
		cr.setCustomRateSequenceNumber("1");
		cr.setCustomRateFromUnit(1.0);
		cr.setCustomRatePerUnit("0");
		return cr;
	}
	
	private CustomRate generateEmptyCustomRateMBHosted(){
		CustomRate cr = new CustomRate();
		cr.setCustomRateClientServiceId("MBHosted");
		cr.setCustomRateSequenceNumber("1");
		cr.setCustomRateFromUnit(1.0);
		cr.setCustomRatePerUnit("0");
		return cr;
	}
	
	private CustomRate generateEmptyCustomRatePagesHosted(){
		CustomRate cr = new CustomRate();
		cr.setCustomRateClientServiceId("PgHosted");
		cr.setCustomRateSequenceNumber("1");
		cr.setCustomRateFromUnit(1.0);
		cr.setCustomRatePerUnit("0");
		return cr;
	}
	
	
	private List<CustomRate> generateCustomRatesForSuppPlan(BillingSystemSuppPlanInstance spi){
		List<CustomRate> finalList= new ArrayList<CustomRate>();
		
	    if(spi.getClientPlanId().equals("Special_Media") && (this.getSourceData().isBilledByPagesUploaded()  
	            || this.getSourceData().isBilledByGBsUploaded()  
	            || this.getSourceData().isBilledByMBsUploaded())) {
			finalList = this.generateCustomRatesForSpecialMedia();
		}
	    else if(spi.getClientPlanId().equals("Special_Media_Hosted")) {
			finalList = this.generateCustomRateForSpecialMediaHosted();
		}
		else if(spi.getClientPlanId().equals("Pages_Uploaded")){
			if(this.getSourceData().isBilledByPagesUploaded()){
				finalList = this.generateCustomRatesForUploaded();
			}
			/*else {
				finalList.add(this.generateEmptyCustomRatePagesUploaded());
			}*/
		}
			
		else if(spi.getClientPlanId().equals("MBs_Uploaded")){
			if(this.getSourceData().isBilledByMBsUploaded()){
				finalList = this.generateCustomRatesForUploaded();
			}
			/*else{
				finalList.add(this.generateEmptyCustomRateMBUploaded());
			}*/
		}
		else if(spi.getClientPlanId().equals("GBs_Uploaded")){
			if(this.getSourceData().isBilledByGBsUploaded()){
				finalList = this.generateCustomRatesForUploaded();
			}
			/*else{
				finalList.add(this.generateEmptyCustomRateGBUploaded());
			}*/
		}
		else if(spi.getClientPlanId().equals("Pages_Hosted")){
			if(this.getSourceData().getUnitOfMeasure().equals("Page"))
				finalList = this.generateCustomRatesForHosted("PgHosted");
		}
			
		else if(spi.getClientPlanId().equals("GBs_Hosted")){
			if(this.getSourceData().getUnitOfMeasure().equals("GB"))
				finalList = this.generateCustomRatesForHosted("GBHosted");

		}
		else if(spi.getClientPlanId().equals("MBs_Hosted")){
			if(this.getSourceData().getUnitOfMeasure().equals("MB"))
				finalList = this.generateCustomRatesForHosted("MBHosted");
		}
		
		return finalList;
	}

	
	private void populateToBeBilledParty(BilledParty billedParty){
		List<BillingSystemContact> contacts = new ArrayList<>();
		contacts.add(populateToBeBillingSystemContact(billedParty));
		
		billedParty.setBillingSystemAccountId(billedParty.getBillingSystemAccountId(this.getSourceData()));

		billedParty.getToBeBillingSystemAccount().setContacts(contacts);
		billedParty.getToBeBillingSystemAccount().setAccountCurrency(this.getSourceData().getCurrency());
		billedParty.getToBeBillingSystemAccount().setCompanyName(billedParty.getSourceData().getBillingCompany().getName());
		billedParty.getToBeBillingSystemAccount().setClientLegalEntity(LegalName.spitLegalName(this.getSourceData().getLegalEntity()).getLegalEntityId());
		billedParty.getToBeBillingSystemAccount().setProrationHostedSuppPlanId(this.determineProrationHostedSuppPlanId(billedParty));
		billedParty.getToBeBillingSystemAccount().setSMprorationHostedSuppPlanId(this.determineSMProrationHostedSuppPlanId(billedParty));
		billedParty.getToBeBillingSystemAccount().setBillingSystemAccountId(billedParty.getBillingSystemAccountId());
		billedParty.getToBeBillingSystemAccount().setBillingSystemMasterPlanId(billedParty.getBillingSystemMasterPlanId());

		BillingSystemMasterPlanInstance masterPlanInstance = billedParty.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance();
		masterPlanInstance.setActiveLabel(billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getActiveLabel());
		masterPlanInstance.setSuspendedDate(billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getSuspendedDate());
		masterPlanInstance.setClientPlanId("DataSite");
		masterPlanInstance.getMasterPlanServices().forEach((u) -> u.setClientServiceLocationId(this.getSourceData().getRevenueSite()));
		masterPlanInstance.setPoNumber(billedParty.getSourceData().getCustomerOrderNumber());
		masterPlanInstance.setRevenueSite(this.getSourceData().getRevenueSite());
		masterPlanInstance.setSalesforceProjectId(this.getSourceData().getProjectSfdcId());
		masterPlanInstance.setBillingAddressIds(billedParty.getSourceData().getBillingAddress().getOracleSiteId());
		masterPlanInstance.setOracleId(billedParty.getSourceData().getBillingAddress().getOracleSiteId());
		masterPlanInstance.setBusinessUnit(this.getSourceData().getBusinessUnit());
		masterPlanInstance.setMediaUsed("0");
		masterPlanInstance.setMediaIncluded(this.getSourceData().getClosureMediaIncluded());
		masterPlanInstance.setContinuationRate(this.getSourceData().getContinuationRate());
		masterPlanInstance.setPanTaxNumber(this.getPanTaxNumber(billedParty));
		masterPlanInstance.setSfdcId(billedParty.getSourceData().getBillingAddress().getSfdcId());
		masterPlanInstance.setLegalEntity(LegalName.spitLegalName(this.getSourceData().getLegalEntity()).getLegalEntityId());
		masterPlanInstance.setLegalEntityName(LegalName.spitLegalName(this.getSourceData().getLegalEntity()).getLegalEntityName());
		masterPlanInstance.setVatRegistrationNumber(billedParty.getSourceData().getBillingCompany().getVatRegistration());
		masterPlanInstance.setVatCountryCode(this.getVATCountryCode(billedParty));
		masterPlanInstance.setContractCustomer(this.getSourceData().getContractCustomerList()[0]);
		masterPlanInstance.setContractCustomerAddress(this.getSourceData().getContractCustomerList()[1]);
		masterPlanInstance.setContractCustomerContact(this.getSourceData().getContractCustomerList()[2]);
		masterPlanInstance.setEffectiveDate(this.getSourceData().getBillingEffectiveDate());
		masterPlanInstance.setHibernationRate(this.getSourceData().getHibernationRate());
		masterPlanInstance.setOperatingUnitName(this.getSourceData().getOperatingUnitId()+"-"+this.getSourceData().getOperatingUnitName());
		masterPlanInstance.setCountryOfIssuer(this.getSourceData().getCountryOfIssuer());
		masterPlanInstance.setContractTerm(this.getSourceData().getContractTerm());
		masterPlanInstance.setHostingLabel(this.getSourceData().getHostingLabelValue());
		masterPlanInstance.setHistoricalEffectiveDate(this.determineHistoricalEffectiveDate(billedParty));

	    masterPlanInstance.setPlanInstanceStatus(this.getAriaMasterPlanStatusValue());
		masterPlanInstance.setPrimaryServiceSite(this.getSourceData().getPrimaryServiceSite());
		masterPlanInstance.setPrimaryRepId(this.getPrimarySalesRep().getEmployeeNumber());
		masterPlanInstance.setPrimaryRepName(this.getPrimarySalesRep().getName());
		masterPlanInstance.setProjectCreationDate(this.getSourceData().getCreatedAt());
		masterPlanInstance.setProjectPhase(this.getProjectPhase());
		masterPlanInstance.setProductType(this.getProductType());
		masterPlanInstance.setRetroactiveStartDate(this.getSourceData().getRetroStartDate());
		masterPlanInstance.setSalesforceProjectName(this.getSourceData().getName());
		masterPlanInstance.setContinuationRateSpecialMedia(this.getSourceData().getContinuationRateSM());
		masterPlanInstance.setHibernationRateSpecialMedia(this.getSourceData().getHibernationRateSM());
		masterPlanInstance.setProcessedForContractMinimum(this.getProcessedForContractMinimum());
		masterPlanInstance.setSalesRepSplitAmount(this.getSalesRepSplitAmount(this.getSourceData().getSalesReps()));
		masterPlanInstance.setSplitBillingAccounts(""); //HC to ""
		masterPlanInstance.setSplitBillingInvText(""); //HC to ""

		masterPlanInstance.setOracleNumber(billedParty.getSourceData().getBillingCompany().getOracleAccountNumber());

		masterPlanInstance.setPrimaryRepId(this.getPrimarySalesRep().getEmployeeNumber());
		masterPlanInstance.setPrimaryRepName(this.getPrimarySalesRep().getName());

		billedParty.getToBeBillingSystemAccount().getBillingGroup().setName(this.getBillingGroupName(billedParty));
		billedParty.getToBeBillingSystemAccount().setBillingSystemDunningGroupId(billedParty.getBillingSystemAccount().getBillingSystemDunningGroupId());
		billedParty.getToBeBillingSystemAccount().getBillingGroup().setBillingGroupNumber(billedParty.getBillingSystemAccount().getBillingGroup().getBillingGroupNumber());

		masterPlanInstance.setMasterPlanServices(this.setDefaultClientServiceId(this.getSourceData().getRevenueSite()));

		this.getProjectDirective().setAriaDoWrite(Boolean.TRUE);

		this.initializeProperties();
	}
	
	private String getVATCountryCode(BilledParty bp){
		if(bp.getSourceData().getBillingCompany().getVatRegistration() == null)
			return "";
		else
			return bp.getSourceData().getBillingAddress().getCountry();
	}
	
	private String getPanTaxNumber(BilledParty bp){
		if(!bp.getSourceData().getBillingAddress().getCountry().equals("IN"))
			return "";
		else{
			LegalName ln = LegalName.spitLegalName(this.getSourceData().getLegalEntity());
			if(ln.getLegalEntityId().equals("010"))
				return "AAHCM5122B";
			else if (ln.getLegalEntityId().equals("071"))
				return "AAHCM0547Q";
			else
				return "";
		}
	}
	
	private String getAriaSuppPlanStatusValue(){
		ProjectSuppPlanStatus sps = null;
		for(ProjectStatus status : ProjectStatus.values()){
			if(status.projectStatus().equalsIgnoreCase(this.getSourceData().getProjectStatus()))
				sps = new ProjectSuppPlanStatus(status);
				
		}
		
		return sps.getSuppPlanStatus(this.getProjectDirective(), this.getIntegrationMetadata());
	}
	
	/**
	 * @author
	 * @since 2017-10-03
	 * @return String Representation of Aria Master Plan Status Value
	 */
	private String getAriaMasterPlanStatusValue(){
		ProjectSuppPlanStatus sps = null;
		for(ProjectStatus status : ProjectStatus.values()){
			if(status.projectStatus().equalsIgnoreCase(this.getSourceData().getProjectStatus()))
				sps = new ProjectSuppPlanStatus(status);
		}
		
		return sps.getMasterPlanStatus(this.getProjectDirective(), this.getIntegrationMetadata());
	}
	
	private String getProductType(){
		if(this.getSourceData().getProductType().equals(""))
			return "";
		else
			return "Datasite-"+this.getSourceData().getProductType();
	}
	
	private SalesRep getPrimarySalesRep(){
		List<SalesRep> salesRepPrimary = this.getSourceData().getSalesReps().stream()
				.filter(i -> i.getIsPrimary() == Boolean.TRUE)
				.collect(Collectors.toList());
		//return salesRepPrimary.get(0);
		if(salesRepPrimary.isEmpty()){
			return new SalesRep();
		}
		else{
			return salesRepPrimary.get(0);
		}
	}
	
	private String getProjectPhase(){
		switch(this.getSourceData().getProjectStatus()){
		case "Build Period": 
			return "Preparation";
		case "Active":
			return "Active";
		case "Active with Continuation":
			return "Active";
		case "Closure_Requested":
			return "Pending Close";
		case "Closed":
			return "Closed";
		case "Hibernation":
			return "Hibernation";
		case "Suspended":
			return "Suspended";
		default:
			return "NOT KNOWN";
		}
	}
	
	private String getProcessedForContractMinimum(){
		if(this.getSourceData().getMinimumFee().equals("0"))
			return "1";
		else
			return "0";
	}
	
	private String getSalesRepSplitAmount(List<SalesRep> salesReps){
		StringBuffer splitAmount = new StringBuffer(300);
		for(SalesRep salesRep : salesReps){
			if(salesReps.indexOf(salesRep)>0){
				splitAmount.append(';'
						+ salesRep.getName()
						+ '|' + salesRep.getEmployeeNumber()
						+ '|' + salesRep.getIsPrimary().toString()
						+ '|' + salesRep.getSplitPercentage().toString());
			}
			else{
				splitAmount.append(salesRep.getName()
						+ '|' + salesRep.getEmployeeNumber()
						+ '|' + salesRep.getIsPrimary().toString()
						+ '|' + salesRep.getSplitPercentage().toString());
			}
		}
		return splitAmount.toString();
	}
	
	public ProjectSuppPlanStatus getProjectSuppPlanStatus(ProjectStatus projectStatus){
		return new ProjectSuppPlanStatus(projectStatus);
	}
	
	public String getSpecialMediaRateAssigned(){
		String result = "";
		if(this.getSourceData().isHibernation())
			result =  this.getSourceData().getHibernationRateSM();
		else if (this.getSourceData().isInContinuation())
			result = this.getSourceData().getContinuationRateSM();
		else
			result = this.getSourceData().getSpecialMediaRate();
		this.specialMediaRateAssigned = result;
		return result;
	}
	public void setIntegrationMetaData (BilledParty billedParty) { 
		if(this.getIntegrationMetadata().getPendingStatusChangeDate() == null || this.getIntegrationMetadata().getPendingStatusChangeDate().equals("")){ 
		    this.getIntegrationMetadata().setPendingStatusChange(""); 
		} 
		else { 
		    this.getIntegrationMetadata().setLastCompletedProjectStatus(billedParty.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getPlanInstanceStatus()); 
		} 
	}
	
	//TODO FIXME Used for Decision of populating
	public void determineAriaSendStatus () {
		if(this.getIntegrationMetadata().getLastCompletedProjectStatus() == null || this.getIntegrationMetadata().getLastCompletedProjectStatus().equals("")){
			this.getProjectDirective().setAriaSendStatus(Boolean.FALSE);
		}
		else if(this.getIntegrationMetadata().getLastCompletedProjectStatus().equals(ProjectStatus.CLOSED.projectStatus()) 
				&& (this.getSourceData().getProjectStatus().equals(ProjectStatus.ACTIVE.projectStatus()) || this.getSourceData().isHibernation() || this.getSourceData().isInContinuation())){
			this.getProjectDirective().setAriaSendStatus(Boolean.TRUE);
		}
		//TODO FIXME Missing From Pending Close Scenarios
		else if (this.getIntegrationMetadata().getLastCompletedProjectStatus().equals(ProjectStatus.SUSPENDED.projectStatus()) && this.getSourceData().getProjectStatus().equals(ProjectStatus.BUILDPERIOD.projectStatus())) {
			this.getProjectDirective().setAriaSendStatus(Boolean.TRUE);
		}
		else if (this.getSourceData().getProjectStatus().equals(ProjectStatus.BUILDPERIOD.projectStatus()) && this.getIntegrationMetadata().getLastCompletedProjectStatus().equals(ProjectStatus.SUSPENDED.projectStatus())) {
			this.getProjectDirective().setAriaSendStatus(Boolean.TRUE);
		}
		else {
			this.getProjectDirective().setAriaSendStatus(Boolean.FALSE);	
		}
	}
 
  public Boolean determineProrationNeeded() {  
    if(this.getProjectDirective().getFromProjState().equalsIgnoreCase(ProjectStatus.ACTIVE.projectStatus())   
        && (this.getSourceData().getProjectStatus().equalsIgnoreCase(ProjectStatus.CONTINUATION.projectStatus())
        || this.getProjectDirective().getToProjState().equalsIgnoreCase(ProjectStatus.HIBERNATION.projectStatus()))){  
         
        return Boolean.TRUE;  
    }  
    else if(this.getSourceData().isInContinuation()  
        && (this.getProjectDirective().getToProjState().equalsIgnoreCase(ProjectStatus.SUSPENDED.projectStatus())   
        || this.getProjectDirective().getToProjState().equalsIgnoreCase(ProjectStatus.HIBERNATION.projectStatus()))) {  
         
        return Boolean.TRUE;  
    }  
    else if(this.getProjectDirective().getFromProjState().equalsIgnoreCase(ProjectStatus.HIBERNATION.projectStatus())  
        && (this.getProjectDirective().getToProjState().equalsIgnoreCase(ProjectStatus.ACTIVE.projectStatus())  
        || this.getSourceData().getProjectStatus().equalsIgnoreCase(ProjectStatus.CONTINUATION.projectStatus()))){
        return Boolean.TRUE;  
    }  
    else {  
        return Boolean.FALSE;  
    }  
  }
  
  public String determineProrationHostedSuppPlanId(BilledParty billedParty) {
	  if(this.getSourceData().getUnitOfMeasure().equalsIgnoreCase("Page")){
		  List<BillingSystemSuppPlanInstance> prorationsuppPlan = billedParty.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getSuppPlans().stream()
					.filter(i -> i.getClientPlanId().equalsIgnoreCase("Pages_Hosted"))
					.collect(Collectors.toList());
		  return prorationsuppPlan.get(0).getClientSuppPlanInstanceId();
	  }
	  if(this.getSourceData().getUnitOfMeasure().equalsIgnoreCase("Mb")){
		  List<BillingSystemSuppPlanInstance> prorationsuppPlan = billedParty.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getSuppPlans().stream()
					.filter(i -> i.getClientPlanId().equalsIgnoreCase("MBs_Hosted"))
					.collect(Collectors.toList());
		  return prorationsuppPlan.get(0).getClientSuppPlanInstanceId();
	  }
	  if(this.getSourceData().getUnitOfMeasure().equalsIgnoreCase("Gb")){
		  List<BillingSystemSuppPlanInstance> prorationsuppPlan = billedParty.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getSuppPlans().stream()
					.filter(i -> i.getClientPlanId().equalsIgnoreCase("GBs_Hosted"))
					.collect(Collectors.toList());
		  return prorationsuppPlan.get(0).getClientSuppPlanInstanceId();
	  }
	  return "";
  }
  
  public String determineSMProrationHostedSuppPlanId(BilledParty billedParty) {
	  List<BillingSystemSuppPlanInstance> prorationsuppPlan = billedParty.getToBeBillingSystemAccount().getBillingSystemMasterPlanInstance().getSuppPlans().stream()
			  .filter(i -> i.getClientPlanId().equalsIgnoreCase("Special_Media_Hosted"))
			  .collect(Collectors.toList());
	  return prorationsuppPlan.get(0).getClientSuppPlanInstanceId();
  }
  
  public void determineProjectStatusValue() {
	  if(this.getSourceData().isInContinuation() && this.getSourceData().getProjectStatus().equalsIgnoreCase(ProjectStatus.ACTIVE.projectStatus())){
		  this.getSourceData().setProjectStatus(ProjectStatus.CONTINUATION.projectStatus());
	  }
	  else{
		  this.getSourceData().setProjectStatus(this.getSourceData().getProjectStatus());
	  }
  }
  
  public String determineHistoricalEffectiveDate(BilledParty billedParty) {
	  if(billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getHistoricalEffectiveDate() == null){
		  return this.getSourceData().getBillingEffectiveDate();
	  }
	  else if(!this.getSourceData().getBillingEffectiveDate().equals(billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getEffectiveDate())) {
		  return billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getHistoricalEffectiveDate() + " , " + this.getSourceData().getBillingEffectiveDate();
	  }
	  else{
		  return billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getHistoricalEffectiveDate();
	  }
  }
  
  public void cleanupMDR(){
	  for(BilledParty bp : this.billedParties){
		  this.determineDoEndDate(bp);
	  }
  }
  
  public void setEachBillingDirective(){
	  for(BilledParty bp : this.billedParties){
		  bp.determineBillToWorkflow(this.projectDirective);
	  }
  }
  
  public void determineDoEndDate(BilledParty billedParty){
	  if(billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getBillingAddressIds() != null 
			  	&& (!billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().getBillingAddressIds().equals(billedParty.getSourceData().getBillingAddress().getOracleSiteId()))){
		  this.getCrossRefs().forEach(x -> {
			  if(x.getIdentifierTypeKey().equals("SF_BILLADDR")){
				  if(!x.getIdentifierValue().equals(billedParty.getSourceData().getBillingAddress().getSfdcId())){
					  x.setDoEndDate(Boolean.TRUE);
				  }
			  }
			  else if(x.getIdentifierTypeKey().equals("ORA_Site")){
				  if(!x.getIdentifierValue().equals(billedParty.getSourceData().getBillingAddress().getOracleSiteId())){
					  x.setDoEndDate(Boolean.TRUE);
				  }
			  }
		  });
	  }
	  if(this.getProjectDirective().getFlowType().equals(ProjectFlowType.UPDATESINGLE) && billedParty.getBillingSystemMasterPlanInstanceId().equals("")){
		  this.getCrossRefs().forEach(x -> {
			  if(x.getIdentifierTypeKey().equals("SF_BILLCO")){
				  if(!x.getIdentifierValue().equals(billedParty.getSourceData().getBillingCompany().getSfdcId())){
					  x.setDoEndDate(Boolean.TRUE);
				  }
			  }
			  else if(x.getIdentifierTypeKey().equals("SF_BILLADDR")){
				  if(!x.getIdentifierValue().equals(billedParty.getSourceData().getBillingAddress().getSfdcId())){
					  x.setDoEndDate(Boolean.TRUE);
				  }
			  }
			  else if(x.getIdentifierTypeKey().equals("ORA_Site")){
				  if(!x.getIdentifierValue().equals(billedParty.getSourceData().getBillingAddress().getOracleSiteId())){
					  x.setDoEndDate(Boolean.TRUE);
				  }
			  }
			  else if(x.getIdentifierTypeKey().equals("ORA_Acct")){
				  if(!x.getIdentifierValue().equals(billedParty.getSourceData().getBillingCompany().getOracleAccountId())){
					  x.setDoEndDate(Boolean.TRUE);
				  }
			  }
			  else if (x.getIdentifierTypeKey().equals("Aria_Acct")) {
				  x.setDoEndDate(Boolean.TRUE);
				  billedParty.setBillingSystemAccountId(x.getIdentifierValue());
			  }
			  else if (x.getIdentifierTypeKey().equals("Aria_MPI")){
				  x.setDoEndDate(Boolean.TRUE);
				  billedParty.setBillingSystemMasterPlanInstanceId(x.getIdentifierValue());
			  }
		  });
	  }
  }
  public void determineReprocessStatus()
  {
	  if(this.integrationMetadata.getCurrentRunTransactionId() == null 
			  && this.ariaAcctXrefExists().equals("FALSE") || this.ariaMpiXrefExists().equals("FALSE")){
		  this.projectDirective.setReprocessStatus(Boolean.TRUE);
	  }
	  else if(this.integrationMetadata.getCurrentRunTransactionId() != null  && this.integrationMetadata.getCurrentRunTransactionId().equals("Finished")){
		  this.projectDirective.setReprocessStatus(Boolean.TRUE);
	  }
	  else if (this.integrationMetadata.getCurrentRunTransactionId() != null  && this.integrationMetadata.getCurrentRunTransactionId().equals("In Process")){
		  this.projectDirective.setReprocessStatus(Boolean.FALSE);
	  }
	  /*else if (this.integrationMetadata.getCurrentRunTransactionId().equals("null") 
			  && this.ariaAcctXrefExists().equals("TRUE") && this.ariaMpiXrefExists().equals("TRUE")){
		  this.projectDirective.setDetermineReprocessStatus(Boolean.TRUE);
	  }*/
  }
  
  /*public CrossRef findAriaAccountToEndDate(BilledParty billedParty, CrossRef projXref) {
	  CrossRef ariaAcctToEndDate = null;
	  for(CrossRef x : this.filterAriaXrefs(billedParty, projXref)){
		  List<CrossRef> ariaAcctXrefToEndDate = this.getCrossRefs().stream()
		  	.filter(projRefs -> projRefs.getIdentifierTypeKey().equals("Aria_Acct")
		  			&& projRefs.getQualifier1Value().equals(x.getQualifier1Value())
		  			&& projRefs.getQualifier2Value().equals(x.getQualifier2Value()))
		  	.collect(Collectors.toList());
		  if(!ariaAcctXrefToEndDate.isEmpty())
			  ariaAcctToEndDate = ariaAcctXrefToEndDate.get(0);
	  }
	  return ariaAcctToEndDate;
  }
  
  public List<CrossRef> filterAriaXrefs(BilledParty billedParty, CrossRef projXref){
	  List<CrossRef> ariaXrefs = billedParty.getSourceData().getCrossRefs().stream()
	  	.filter(bpXref -> bpXref.getIdentifierTypeKey().equals("SF_BILLCO") && bpXref.getIdentifierValue().equals(projXref.getIdentifierValue()))
	  	.collect(Collectors.toList());
	  return ariaXrefs;
  }
  
  public void determineAriaAccountsToEndDate(CrossRef ariaAcctToEndDate){
	  this.getCrossRefs().forEach(x -> {
		  if(x.getIdentifierTypeKey().equals("Aria_MPI") && x.getQualifier1Value().equals(ariaAcctToEndDate.getIdentifierValue())){
			  ariaAcctToEndDate.setDoEndDate(Boolean.TRUE);
			  x.setDoEndDate(Boolean.TRUE);
		  }
	  });
  }*/
}
