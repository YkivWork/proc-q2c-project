package com.merrillcorp.enterprise.canonical.models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.merrillcorp.enterprise.utilities.MasterPlanInstanceProperty;


/**
 * <h1>Billing System Master Plan Instance</h1>
 * @author podo-crennert
 * @since 2017-10-03
 *
 */
public class BillingSystemMasterPlanInstance implements Serializable {

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private static final long serialVersionUID = -5838049766745661463L;
	private String clientPlanId; //client_master_plan_id
	private String planInstanceStatus; //master_plan_instance_status
	private String planInstanceStatusDirective;
	private List<MasterPlanServiceItem> masterPlanServices;
	private String poNumber;  //po_num
	private String billingAddressIds;
	private String businessUnit;
	private String mediaUsed;
	private String mediaUsedDirective;
	private String mediaIncluded;
	private String mediaIncludedDirective;
	private String continuationRate;
	private String continuationRateDirective;
	private String contractCustomer;
	private String contractCustomerDirective;
	private String contractCustomerAddress;
	private String contractCustomerContact;
	private String contractTerm;
	private String countryOfIssuer;
	private String currentEntitlement;
	private String currentEntitlementDirective;
	private String effectiveDate; //EFFECTIVE_DATE
	private String effectiveDateDirective;
	private String hibernationRate; //HIBERNATION_RATE
	private String hibernationRateDirective;
	private String operatingUnitName;
	private String primaryServiceSite;
	private String primaryRepId;
	private String primaryRepName;
	private String productType;//PRODUCT_TYPE
	private String productTypeDirective;
	private String projectCreationDate;
	private String projectPhase;
	private String projectPhaseDirective;
	private String revenueSite;  //REVENUE_SITE
	private String revenueSiteDirective;
	private String salesforceProjectId; //SALESFORCE_PROJECT_ID
	private String salesforceProjectIdDirective;
	private String salesforceProjectName;
	private String salesforceProjectNameDirective;
	private String processedForContractMinimum;
	private String processedForContractMinimumDirective;
	private String continuationRateSpecialMedia;
	private String continuationRateSpecialMediaDirective;
	private String hibernationRateSpecialMedia;
	private String hibernationRateSpecialMediaDirective;
	private String salesRepSplitAmount;
	private String salesRepSplitAmountDirective;
	private String splitBillingAccounts;
	private String splitBillingAccountsDirective;
	private String splitBillingInvText;
	private String splitBillingInvTextDirective;
	private String hibernateOutDate;
	private String hibernateOutDateDirective;
	private List<BillingSystemSuppPlanInstance> suppPlans;
	private String retroactiveStartDate;
	private String retroactiveStartDateDirective;
	private String nextBillDate; //TODO Added this, generate getters/setters if needed
	private String nextBillDateDirective;
	private String invoiceTermVerbiage;
	private String invoiceFooterNote;
	private String invoiceFooterLeft;
	private String invoiceFooterRight;
	private String invoiceHeaderLeft;
	private String invoiceHeaderRight;
	private String legalEntity; //legal_entity_no
	private String legalEntityName; //legal_entity_name
	private String oracleId;
	private String oracleIdDirective;
	private String oracleNumber;
	private String oracleNumberDirective;
	private String panTaxNumber;
	private String panTaxNumberDirective;
	private String sfdcId;
	private String sfdcIdDirective;
	private String vatRegistrationNumber;
	private String vatCountryCode;
	private List<MasterPlanProductField> masterPlanProductFields;
	private List<MasterPlanInstanceField> masterPlanInstanceFields;
	private List<Entitlement> entitlements;
	private String activeLabel;
	private String activeLabelDirective;
	private String closeDate;
	private String closeDateDirective;
	private String hibernateDate; //TODO Rename to hibernationDate?
	private String hibernateDateDirective;
	private String suspendedDate;
	private String pendingCloseDate;
	private String pendingCloseDateDirective;
	private String hostingLabel;
	private String hostingLabelDirective;
	private String activeDate;
	private String activeDateDirective;
	private String historicalEffectiveDate;
	private String historicalEffectiveDateDirective;
	private String continuationDate;
	private String continuationDateDirective;

	
	private PropertyChangeListener projSourceDataListener = new PropertyChangeListener(){
	      public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
	          String property = propertyChangeEvent.getPropertyName();
	          if(property.equals("hibernateOutDate")){
	        	  if(hibernateOutDate == null || hibernateOutDate.equals(""))
	        		  hibernateOutDateDirective = "1";
	        	  else
	        		  hibernateOutDateDirective = "2";
	        	 
	          }
	          else if(property.equals("projectPhase")){
	        	  if(projectPhase == null || projectPhase.equals(""))
	        		  projectPhaseDirective = "1";
	        	  else
	        		  projectPhaseDirective = "2";
	          }
	          else if(property.equals("hostingLabel")){
	        	  if(hostingLabel == null || hostingLabel.equals(""))
	        		  hostingLabelDirective = "1";
	        	  else
	        		  hostingLabelDirective = "2";
	          }

        }
	};
	
	public String getHibernateOutDateDirective() {
		return hibernateOutDateDirective;
	}

	public void setHibernateOutDateDirective(String hibernateOutDateDirective) {
		this.hibernateOutDateDirective = hibernateOutDateDirective;
	}

	public String getHibernateOutDate() {
		return hibernateOutDate;
	}

	public void setHibernateOutDate(String hibernateOutDate) {
		
		this.hibernateOutDate = hibernateOutDate;
		
	}

	public String getNextBillDate() {
		return nextBillDate;
	}

	public void setNextBillDate(String nextBillDate) {
		this.nextBillDate = nextBillDate;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}
	
	public Boolean hostingLabelBlankOrNull(){
		if (this.getHostingLabel() == null 
				|| this.getHostingLabel().equals(""))
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}
	public String getHostingLabel() {
		return hostingLabel;
	}

	public void setHostingLabel(String hostingLabel) {
		
		if(hostingLabel == null || hostingLabel.equals(""))
			this.hostingLabelDirective = "1";
		else
			this.hostingLabelDirective = "2";
		this.hostingLabel = hostingLabel;
		
	}

	public String getActiveLabel() {
		return activeLabel;
	}

	public void setActiveLabel(String activeLabel) {
		this.activeLabel = activeLabel;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getHibernateDate() {
		return hibernateDate;
	}

	public void setHibernateDate(String hibernateDate) {
		this.hibernateDate = hibernateDate;
	}

	public String getSuspendedDate() {
		return suspendedDate;
	}

	public void setSuspendedDate(String suspendedDate) {
		this.suspendedDate = suspendedDate;
	}

	public String getPendingCloseDate() {
		return pendingCloseDate;
	}

	public void setPendingCloseDate(String pendingCloseDate) {
		this.pendingCloseDate = pendingCloseDate;
	}

	public List<Entitlement> getEntitlements() {
		return entitlements;
	}

	public void setEntitlements(List<Entitlement> entitlements) {
		this.entitlements = entitlements;
	}

	public List<MasterPlanProductField> getMasterPlanProductFields() {
		return masterPlanProductFields;
	}

	public void setMasterPlanProductFields(List<MasterPlanProductField> masterPlanProductFields) {
		this.masterPlanProductFields = masterPlanProductFields;
	}

	public List<MasterPlanInstanceField> getMasterPlanInstanceFields() {
		return masterPlanInstanceFields;
	}

	public void setMasterPlanInstanceFields(List<MasterPlanInstanceField> masterPlanInstanceFields) {
		this.masterPlanInstanceFields = masterPlanInstanceFields;
	}
	
	/**
	 * <h1>Billing System Master Plan Instance Constructor</h1>
	 * @author podo-crennert
	 * @since 2017-10-03
	 */
	public BillingSystemMasterPlanInstance(){
		this.masterPlanServices = new ArrayList<MasterPlanServiceItem>();
		this.suppPlans = new ArrayList<BillingSystemSuppPlanInstance>();
		this.masterPlanInstanceFields = new ArrayList<MasterPlanInstanceField>();
		this.masterPlanProductFields = new ArrayList<MasterPlanProductField>();
		this.entitlements = new ArrayList<Entitlement>();
	}
	
	public String getClientPlanId() {
		return clientPlanId;
	}
	
	public void setClientPlanId(String clientPlanId) {
		this.clientPlanId = clientPlanId;
	}
	
	public String getPlanInstanceStatus() {
		return planInstanceStatus;
	}
	
	public void setPlanInstanceStatus(String planInstanceStatus) {
		this.planInstanceStatus = planInstanceStatus;
	}
	
	public List<MasterPlanServiceItem> getMasterPlanServices() {
		return masterPlanServices;
	}
	
	public void setMasterPlanServices(List<MasterPlanServiceItem> masterPlanServices) {
		this.masterPlanServices = masterPlanServices;
	}
	
	public String getPoNumber() {
		return poNumber;
	}
	
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	
	public String getBillingAddressIds() {
		return billingAddressIds;
	}
	
	public void setBillingAddressIds(String billingAddressIds) {
		this.billingAddressIds = billingAddressIds;
	}
	
	public String getBusinessUnit() {
		return businessUnit;
	}
	
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	
	public String getMediaUsed() {
		return mediaUsed;
	}
	
	public void setMediaUsed(String mediaUsed) {
		this.mediaUsed = mediaUsed;
	}
	
	public String getMediaIncluded() {
		return mediaIncluded;
	}
	
	public void setMediaIncluded(String mediaIncluded) {
		this.mediaIncluded = mediaIncluded;
	}

	public String getContinuationDate() {
		return continuationDate;
	}
	
	public void setContinuationDate(String continuationDate) {
		this.continuationDate = continuationDate;
	}

	public String getContinuationRate() {
		return continuationRate;
	}
	
	public void setContinuationRate(String continuationRate) {
		this.continuationRate = continuationRate;
	}
	
	public String getContractCustomer() {
		return contractCustomer;
	}
	
	public void setContractCustomer(String contractCustomer) {
		this.contractCustomer = contractCustomer;
	}
	
	public String getContractCustomerAddress() {
		return contractCustomerAddress;
	}
	
	public void setContractCustomerAddress(String contractCustomerAddress) {
		this.contractCustomerAddress = contractCustomerAddress;
	}
	
	public String getContractCustomerContact() {
		return contractCustomerContact;
	}
	
	public void setContractCustomerContact(String contractCustomerContact) {
		this.contractCustomerContact = contractCustomerContact;
	}
	
	public String getContractTerm() {
		return contractTerm;
	}
	
	public void setContractTerm(String contractTerm) {
		this.contractTerm = contractTerm;
	}
	
	public String getCountryOfIssuer() {
		return countryOfIssuer;
	}
	
	public void setCountryOfIssuer(String countryOfIssuer) {
		this.countryOfIssuer = countryOfIssuer;
	}
	
	public String getCurrentEntitlement() {
		return currentEntitlement;
	}
	
	public void setCurrentEntitlement(String currentEntitlement) {
		this.currentEntitlement = currentEntitlement;
	}
	
	public String getEffectiveDate() {
		return effectiveDate;
	}
	
	public void setEffectiveDate(String effectiveDate) {
		if(effectiveDate != null){
			String oldVal = this.effectiveDate;
			this.effectiveDate = effectiveDate;
			pcs.firePropertyChange("effectiveDate", oldVal, this.effectiveDate);
		}
	}
	public String getHibernationRate() {
		return hibernationRate;
	}
	public void setHibernationRate(String hibernationRate) {
		this.hibernationRate = hibernationRate;
	}
	public String getOperatingUnitName() {
		return operatingUnitName;
	}
	public void setOperatingUnitName(String operatingUnitName) {
		this.operatingUnitName = operatingUnitName;
	}
	public String getPrimaryServiceSite() {
		return primaryServiceSite;
	}
	public void setPrimaryServiceSite(String primaryServiceSite) {
		this.primaryServiceSite = primaryServiceSite;
	}
	public String getPrimaryRepId() {
		return primaryRepId;
	}
	public void setPrimaryRepId(String primaryRepId) {
		this.primaryRepId = primaryRepId;
	}
	public String getPrimaryRepName() {
		return primaryRepName;
	}
	public void setPrimaryRepName(String primaryRepName) {
		this.primaryRepName = primaryRepName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProjectCreationDate() {
		return projectCreationDate;
	}
	public void setProjectCreationDate(String projectCreationDate) {
		this.projectCreationDate = projectCreationDate;
	}
	public String getProjectPhase() {
		return projectPhase;
	}
	public void setProjectPhase(String projectPhase) {
		this.projectPhase = projectPhase;
	}
	public String getRevenueSite() {
		return revenueSite;
	}
	public void setRevenueSite(String revenueSite) {
		this.revenueSite = revenueSite;
	}
	public String getSalesforceProjectId() {
		return salesforceProjectId;
	}
	public void setSalesforceProjectId(String salesforceProjectId) {
		this.salesforceProjectId = salesforceProjectId;
	}
	public String getSalesforceProjectName() {
		return salesforceProjectName;
	}
	public void setSalesforceProjectName(String salesforceProjectName) {
		this.salesforceProjectName = salesforceProjectName;
	}
	public String getProcessedForContractMinimum() {
		return processedForContractMinimum;
	}
	public void setProcessedForContractMinimum(String processedForContractMinimum) {
		this.processedForContractMinimum = processedForContractMinimum;
	}
	public String getContinuationRateSpecialMedia() {
		return continuationRateSpecialMedia;
	}
	public void setContinuationRateSpecialMedia(String continuationRateSpecialMedia) {
		this.continuationRateSpecialMedia = continuationRateSpecialMedia;
	}
	public String getHibernationRateSpecialMedia() {
		return hibernationRateSpecialMedia;
	}
	public void setHibernationRateSpecialMedia(String hibernationRateSpecialMedia) {
		this.hibernationRateSpecialMedia = hibernationRateSpecialMedia;
	}
	public String getSalesRepSplitAmount() {
		return salesRepSplitAmount;
	}
	public void setSalesRepSplitAmount(String salesRepSplitAmount) {
		this.salesRepSplitAmount = salesRepSplitAmount;
	}
	public String getSplitBillingAccounts() {
		return splitBillingAccounts;
	}
	public void setSplitBillingAccounts(String splitBillingAccounts) {
		this.splitBillingAccounts = splitBillingAccounts;
	}
	public String getSplitBillingInvText() {
		return splitBillingInvText;
	}
	public void setSplitBillingInvText(String splitBillingInvText) {
		this.splitBillingInvText = splitBillingInvText;
	}
	public List<BillingSystemSuppPlanInstance> getSuppPlans() {
		return suppPlans;
	}
	public void setSuppPlans(List<BillingSystemSuppPlanInstance> suppPlans) {
		this.suppPlans = suppPlans;
	}
	public String getRetroactiveStartDate() {
		return retroactiveStartDate;
	}
	public void setRetroactiveStartDate(String retroactiveStartDate) {
		this.retroactiveStartDate = retroactiveStartDate;
	}
	public String getInvoiceTermVerbiage() {
		return invoiceTermVerbiage;
	}
	public void setInvoiceTermVerbiage(String invoiceTermVerbiage) {
		this.invoiceTermVerbiage = invoiceTermVerbiage;
	}
	public String getInvoiceFooterNote() {
		return invoiceFooterNote;
	}
	public void setInvoiceFooterNote(String invoiceFooterNote) {
		this.invoiceFooterNote = invoiceFooterNote;
	}
	public String getInvoiceFooterLeft() {
		return invoiceFooterLeft;
	}
	public void setInvoiceFooterLeft(String invoiceFooterLeft) {
		this.invoiceFooterLeft = invoiceFooterLeft;
	}
	public String getInvoiceFooterRight() {
		return invoiceFooterRight;
	}
	public void setInvoiceFooterRight(String invoiceFooterRight) {
		this.invoiceFooterRight = invoiceFooterRight;
	}
	public String getInvoiceHeaderLeft() {
		return invoiceHeaderLeft;
	}
	public void setInvoiceHeaderLeft(String invoiceHeaderLeft) {
		this.invoiceHeaderLeft = invoiceHeaderLeft;
	}
	public String getInvoiceHeaderRight() {
		return invoiceHeaderRight;
	}
	public void setInvoiceHeaderRight(String invoiceHeaderRight) {
		this.invoiceHeaderRight = invoiceHeaderRight;
	}
	public String getLegalEntity() {
		return legalEntity;
	}
	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}
	public String getLegalEntityName() {
		return legalEntityName;
	}
	public void setLegalEntityName(String legalEntityName) {
		this.legalEntityName = legalEntityName;
	}
	public String getOracleId() {
		return oracleId;
	}
	public void setOracleId(String oracleId) {
		this.oracleId = oracleId;
	}
	public String getOracleNumber() { return oracleNumber; }
	public void setOracleNumber(String oracleNumber) {
		this.oracleNumber = oracleNumber;
	}
	public String getPanTaxNumber() { return panTaxNumber; }
	public void setPanTaxNumber(String panTaxNumber) {
		this.panTaxNumber = panTaxNumber;
	}
	public String getSfdcId() {
		return sfdcId;
	}
	public void setSfdcId(String sfdcId) {
		this.sfdcId = sfdcId;
	}
	public String getVatRegistrationNumber() {
		return vatRegistrationNumber;
	}
	public void setVatRegistrationNumber(String vatRegistrationNumber) {
		this.vatRegistrationNumber = vatRegistrationNumber;
	}
	public String getVatCountryCode() {
		return vatCountryCode;
	}
	public void setVatCountryCode(String vatCountryCode) {
		this.vatCountryCode = vatCountryCode;
	}

	public String getHistoricalEffectiveDate() {
		return historicalEffectiveDate;
	}

	
	public void setHistoricalEffectiveDate(String historicalEffectiveDate) {
		if(historicalEffectiveDate != null){
			String oldVal = this.historicalEffectiveDate;
			this.historicalEffectiveDate = historicalEffectiveDate;
			pcs.firePropertyChange("historicalEffectiveDate", oldVal, this.historicalEffectiveDate);
		}
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
	}
	
}
