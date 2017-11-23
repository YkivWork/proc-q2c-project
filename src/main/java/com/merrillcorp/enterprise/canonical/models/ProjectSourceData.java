package com.merrillcorp.enterprise.canonical.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ProjectSourceData implements Serializable {
	private static Logger logger = LoggerFactory.getLogger(ProjectSourceData.class);

	/**
	 * 
	 */
	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	private static final long serialVersionUID = 2338580848277969136L;
	private String activeDate;
	private String adminEmail;
	private String ariaCreation;
	private String billingEffectiveDate;
	private String businessUnit;
	private String closureMediaIncluded;
	private String continuationDate;
	private String continuationRate;
	private String continuationRateSM;
	private String contractCustomer;
	private String contractTerm;
	private String countryOfIssuer;
	private String createdAt;
	private String currency;
	private String dataCenter;
	private String datasiteOneId;
	private String effectiveDate;
	private String hibernateDate;
	private String hibernationRate;
	private String hibernationRateSM;
	private String legalEntity;
	private String minimumFee;
	private String modifiedAt;
	private String name;
	private String operatingUnitId;
	private String operatingUnitName;
	private String primaryServiceSite;
	private String productType;
	private String projectCreateDate;
	private String projectSfdcId;
	private String projectStatus;
	private String retroStartDate;
	private String revenueSite;
	private String sales;
	private String specialMediaRate;
	private Double tier1Rate;
	private Double tier1UpperLimit;
	private Double tier2Rate;
	private Double tier2UpperLimit;
	private Double tier3Rate;
	private Double tier3UpperLimit;
	private Double tier4Rate;
	private Double tier4UpperLimit;
	private Double tier5Rate;
	private Double tier5UpperLimit;
	private Double tier6Rate;
	private Double tier6UpperLimit;
	private Double tier7Rate;
	private Double tier7UpperLimit;	
	private Double tier8Rate;
	private Double tier8UpperLimit;
	private Double tier9Rate;
	private Double tier9UpperLimit;
	private Double tier10Rate;
	private String unitOfMeasure;
	private String ariaAccountCreate;
	private List<SalesRep> salesReps;
	private String promotionalDiscount;
	private String updatePlanStatus;
	private String closedDate;
	private String closureRequestedDate;
	private String suspendedDate;
	

	public ProjectSourceData(){
		this.salesReps = new ArrayList<SalesRep>();
	}
	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAriaCreation() {
		return ariaCreation;
	}

	public void setAriaCreation(String ariaCreation) {
		this.ariaCreation = ariaCreation;
	}

	public String getBillingEffectiveDate() {
		return billingEffectiveDate;
	}

	public void setBillingEffectiveDate(String billingEffectiveDate) {
		this.billingEffectiveDate = billingEffectiveDate;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getClosureMediaIncluded() {
		return closureMediaIncluded;
	}

	public void setClosureMediaIncluded(String closureMediaIncluded) {
		this.closureMediaIncluded = closureMediaIncluded;
	}

	public String getContinuationDate() {
		return continuationDate;
	}

	public void setContinuationDate(String continuationDate) {
		if(continuationDate != null){
			String oldVal = this.continuationDate;
			this.continuationDate = continuationDate;
			pcs.firePropertyChange("continuationDate", oldVal, this.continuationDate);
		}
	}

	public String getContinuationRate() {
		return continuationRate;
	}

	public void setContinuationRate(String continuationRate) {
		this.continuationRate = continuationRate;
	}

	public String getContinuationRateSM() {
		return continuationRateSM;
	}

	public void setContinuationRateSM(String continuationRateSM) {
		this.continuationRateSM = continuationRateSM;
	}

	public String getContractCustomer() {
		return contractCustomer;
	}

	public void setContractCustomer(String contractCustomer) {
		this.contractCustomer = contractCustomer;
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDataCenter() {
		return dataCenter;
	}

	public void setDataCenter(String dataCenter) {
		this.dataCenter = dataCenter;
	}

	public String getDatasiteOneId() {
		return datasiteOneId;
	}

	public void setDatasiteOneId(String datasiteOneId) {
		this.datasiteOneId = datasiteOneId;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getHibernationRate() {
		return hibernationRate;
	}

	public void setHibernationRate(String hibernationRate) {
		this.hibernationRate = hibernationRate;
	}

	public String getHibernationRateSM() {
		return hibernationRateSM;
	}

	public void setHibernationRateSM(String hibernationRateSM) {
		this.hibernationRateSM = hibernationRateSM;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public String getMinimumFee() {
		return minimumFee;
	}

	public void setMinimumFee(String minimumFee) {
		this.minimumFee = minimumFee;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperatingUnitId() {
		return operatingUnitId;
	}

	public void setOperatingUnitId(String operatingUnitId) {
		this.operatingUnitId = operatingUnitId;
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

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProjectCreateDate() {
		return projectCreateDate;
	}

	public void setProjectCreateDate(String projectCreateDate) {
		this.projectCreateDate = projectCreateDate;
	}

	public String getProjectSfdcId() {
		return projectSfdcId;
	}

	public void setProjectSfdcId(String projectSfdcId) {
		this.projectSfdcId = projectSfdcId;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		if(projectStatus != null){
			String oldVal = this.projectStatus;
			this.projectStatus = projectStatus;
			pcs.firePropertyChange("projectStatus", oldVal, projectStatus);
		}
	}

	public String getRetroStartDate() {
		return retroStartDate;
	}

	public void setRetroStartDate(String retroStartDate) {
		this.retroStartDate = retroStartDate;
	}

	public String getRevenueSite() {
		return revenueSite;
	}

	public void setRevenueSite(String revenueSite) {
		this.revenueSite = revenueSite;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getSpecialMediaRate() {
		return specialMediaRate;
	}

	public void setSpecialMediaRate(String specialMediaRate) {
		this.specialMediaRate = specialMediaRate;
	}

	public Double getTier1Rate() {
		return tier1Rate;
	}

	public void setTier1Rate(Double tier1Rate) {
		this.tier1Rate = tier1Rate;
	}

	public Double getTier1UpperLimit() {
		return tier1UpperLimit;
	}

	public void setTier1UpperLimit(Double tier1UpperLimit) {
		this.tier1UpperLimit = tier1UpperLimit;
	}

	public Double getTier2Rate() {
		return tier2Rate;
	}

	public void setTier2Rate(Double tier2Rate) {
		this.tier2Rate = tier2Rate;
	}

	public Double getTier2UpperLimit() {
		return tier2UpperLimit;
	}

	public void setTier2UpperLimit(Double tier2UpperLimit) {
		this.tier2UpperLimit = tier2UpperLimit;
	}

	public Double getTier3Rate() {
		return tier3Rate;
	}

	public void setTier3Rate(Double tier3Rate) {
		this.tier3Rate = tier3Rate;
	}

	public Double getTier3UpperLimit() {
		return tier3UpperLimit;
	}

	public void setTier3UpperLimit(Double tier3UpperLimit) {
		this.tier3UpperLimit = tier3UpperLimit;
	}

	public Double getTier4Rate() {
		return tier4Rate;
	}

	public void setTier4Rate(Double tier4Rate) {
		this.tier4Rate = tier4Rate;
	}

	public Double getTier4UpperLimit() {
		return tier4UpperLimit;
	}

	public void setTier4UpperLimit(Double tier4UpperLimit) {
		this.tier4UpperLimit = tier4UpperLimit;
	}

	public Double getTier5Rate() {
		return tier5Rate;
	}

	public void setTier5Rate(Double tier5Rate) {
		this.tier5Rate = tier5Rate;
	}

	public Double getTier5UpperLimit() {
		return tier5UpperLimit;
	}

	public void setTier5UpperLimit(Double tier5UpperLimit) {
		this.tier5UpperLimit = tier5UpperLimit;
	}

	public Double getTier6Rate() {
		return tier6Rate;
	}

	public void setTier6Rate(Double tier6Rate) {
		this.tier6Rate = tier6Rate;
	}

	public Double getTier6UpperLimit() {
		return tier6UpperLimit;
	}

	public void setTier6UpperLimit(Double tier6UpperLimit) {
		this.tier6UpperLimit = tier6UpperLimit;
	}

	public Double getTier7Rate() {
		return tier7Rate;
	}

	public void setTier7Rate(Double tier7Rate) {
		this.tier7Rate = tier7Rate;
	}

	public Double getTier7UpperLimit() {
		return tier7UpperLimit;
	}

	public void setTier7UpperLimit(Double tier7UpperLimit) {
		this.tier7UpperLimit = tier7UpperLimit;
	}

	public Double getTier8Rate() {
		return tier8Rate;
	}

	public void setTier8Rate(Double tier8Rate) {
		this.tier8Rate = tier8Rate;
	}

	public Double getTier8UpperLimit() {
		return tier8UpperLimit;
	}

	public void setTier8UpperLimit(Double tier8UpperLimit) {
		this.tier8UpperLimit = tier8UpperLimit;
	}

	public Double getTier9Rate() {
		return tier9Rate;
	}

	public void setTier9Rate(Double tier9Rate) {
		this.tier9Rate = tier9Rate;
	}

	public Double getTier9UpperLimit() {
		return tier9UpperLimit;
	}

	public void setTier9UpperLimit(Double tier9UpperLimit) {
		this.tier9UpperLimit = tier9UpperLimit;
	}

	public Double getTier10Rate() {
		return tier10Rate;
	}

	public void setTier10Rate(Double tier10Rate) {
		this.tier10Rate = tier10Rate;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		if(unitOfMeasure != null){
			String oldVal = this.unitOfMeasure;
			this.unitOfMeasure = unitOfMeasure;
			pcs.firePropertyChange("unitOfMeasure", oldVal, this.unitOfMeasure);
		}
	}

	public String getAriaAccountCreate() {
		return ariaAccountCreate;
	}

	public void setAriaAccountCreate(String ariaAccountCreate) {
		this.ariaAccountCreate = ariaAccountCreate;
	}

	public List<SalesRep> getSalesReps() {
		return salesReps;
	}

	public void setSalesReps(List<SalesRep> salesReps) {
		this.salesReps = salesReps;
	}
	public boolean isSuspended(){
		return this.projectStatus.equals("Suspended");
	}
	
	public boolean isActive(){
		return this.projectStatus.equals("Active") || this.projectStatus.equals("Active with Continuation");
	}
	
	public boolean isClosed(){
		return this.projectStatus.equals("Closed");
	}
	
	public boolean isHibernation(){
		return this.projectStatus.equals("Hibernation");
	}
	
	public boolean isBuildPeriod(){
		return this.projectStatus.equals("Build Period");
	}
	
	public boolean isClosureRequest(){
		return this.projectStatus.equals("Closure Request");
	}
	
	public String getClientPlanName(){
		String result = null;
		if(this.isBilledByPagesUploaded())
			result = "Pages_Uploaded";
		else if(this.isBilledByMBsUploaded())
			result = "MBs_Uploaded";
		else if(this.isBilledByGBsUploaded())
			result = "GBs_Uploaded";
		else if(this.isBilledByPagesHosted())
			result = "Pages_Hosted";
		else if(this.isBilledByMBsHosted())
			result = "MBs_Hosted";
		else if(this.isBilledByGBsHosted())
			result = "GBs_Hosted";
		else
			result = "";
		//"Special_Media"
		//"Special_Media_Hosted"
		
		return result;
	}
	
	public String getClientServiceName(){
		String result = null;
		if(this.isBilledByPagesUploaded())
			result = "PgUploaded";
		else if(this.isBilledByMBsUploaded())
			result = "MBUploaded";
		else if(this.isBilledByGBsUploaded())
			result = "GBUploaded";
		else if(this.isBilledByPagesHosted())
			result = "PgHosted";
		else if(this.isBilledByMBsHosted())
			result = "MBHosted";
		else if(this.isBilledByGBsHosted())
			result = "GBHosted";
		else
			result = "";
		//SMHosted
		//SMUploaded
		
		return result;
	}
	
	public String getClientServiceNameMinimumFee(){
		switch(this.unitOfMeasure){
			case "Page" :
				return "PgMinimumFee";
			case "MB":
				return "MBMinimumFee";
			case "GB":
				return "GBMinimumFee";
			default:
				return "";
		}
	}
	
	public boolean hasMinimumFee(){
		return this.minimumFee.length() > 0;
	}
	
	public String[] getContractCustomerList(){
		return this.contractCustomer.split(",");
	}
	
	public Boolean isBilledByPages(){
		return this.unitOfMeasure.equals("Page");
	}
	
	public Boolean isBilledByMBs(){
		return this.unitOfMeasure.equals("MB");
	}
	
	public Boolean isBilledByGBs(){
		return this.unitOfMeasure.equals("GB");
	}
	
	public Boolean isBilledByUploaded(){
		return this.isBilledByPagesUploaded() || this.isBilledByMBsUploaded() || this.isBilledByGBsUploaded();
	}
	
	public Boolean isBilledByHosted(){
		return this.isBilledByPagesHosted() || this.isBilledByMBsHosted() || this.isBilledByGBsHosted();
	}
	
	public Boolean hibernateOrInContinuation(){
		return ((this.isHibernation()) || (this.isActive() && this.isInContinuation()));
	}
	
	public Boolean isInContinuation(){
		Boolean result = Boolean.FALSE;
		//DateTimeFormatter formatter = new DateTimeFormatter().ofPattern("dd-MM-uuuu")
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
			if (this.getContinuationDate() != null && !this.getContinuationDate().equals("")){
				Date date = formatter.parse(this.getContinuationDate());
				Date now = new Date();
				result = (now.after(date) || now.equals(date));
			}
			else
				result = Boolean.FALSE;
		}
		catch (ParseException e){
			result = Boolean.FALSE;
		}
		return result;
	}
	
	public String getHostingLabelValue(){
		String result = "";
		if(this.isInContinuation())
			result = "In Continuation";
		else if(this.isHibernation())
			result = "In Hibernation";
		return result;
	}
	
	public Boolean isBilledByPagesHosted(){
		Boolean result = this.hibernateOrInContinuation() && this.isBilledByPages();
		
		return result;
	}
	
	public Boolean isBilledByMBsHosted(){
		return this.hibernateOrInContinuation() && this.isBilledByMBs();
	}
	
	public Boolean isBilledByGBsHosted(){
		return this.hibernateOrInContinuation() && this.isBilledByGBs();
	}
	
	public Boolean isSpecialMediaHosted(){
		return this.hibernateOrInContinuation();
	}
	
	public Boolean isBilledByPagesUploaded(){
		return (!this.isBilledByPagesHosted()) && this.isBilledByPages();
	}
	
	public Boolean isBilledByMBsUploaded(){
		return (!this.isBilledByMBsHosted()) && this.isBilledByMBs();
	}
	
	public Boolean isBilledByGBsUploaded(){
		return (!this.isBilledByGBsHosted()) && this.isBilledByGBs();
	}
	public String getPromotionalDiscount() {
		return promotionalDiscount;
	}
	public void setPromotionalDiscount(String promotionalDiscount) {
		this.promotionalDiscount = promotionalDiscount;
	}
	public String getUpdatePlanStatus() {
		return updatePlanStatus;
	}
	public void setUpdatePlanStatus(String updatePlanStatus) {
		this.updatePlanStatus = updatePlanStatus;
	}
	public String getHibernateDate() {
		return hibernateDate;
	}
	public void setHibernateDate(String hibernateDate) {
		this.hibernateDate = hibernateDate;
	}
	public String getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}
	public String getClosureRequestedDate() {
		return closureRequestedDate;
	}
	public void setClosureRequestedDate(String closureRequestedDate) {
		this.closureRequestedDate = closureRequestedDate;
	}
	public String getSuspendedDate() {
		return suspendedDate;
	}
	public void setSuspendedDate(String suspendedDate) {
		this.suspendedDate = suspendedDate;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		            pcs.addPropertyChangeListener(listener);
	}
}
