package com.merrillcorp.enterprise.canonical.models.aria;

import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merrillcorp.enterprise.canonical.models.BilledParty;
import com.merrillcorp.enterprise.canonical.models.BillingSystemContact;
import com.merrillcorp.enterprise.canonical.models.BillingSystemMasterPlanInstance;
import com.merrillcorp.enterprise.canonical.models.BillingSystemSuppPlanInstance;
import com.merrillcorp.enterprise.canonical.models.MasterPlanServiceItem;
import com.merrillcorp.enterprise.canonical.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AriaAccountDetails implements Serializable {
	private static Logger logger = LoggerFactory.getLogger(Project.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 524225513593683179L;
	

	//Map Billing System Master Plan Instance
	private static BillingSystemMasterPlanInstance mapBillingSystemMasterPlanInstance(JsonNode mpiNode){
		BillingSystemMasterPlanInstance mpi = new BillingSystemMasterPlanInstance();
		//mpi.setBillingAddressIds(mpiNode.get("").asText());
		//mpi.setBusinessUnit(mpiNode.get("").asText());
		mpi.setPoNumber(mpiNode.get("po_num").asText());
		mpi.setPlanInstanceStatus(mpiNode.get("master_plan_instance_status").asText());
		JsonNode mpiServiceNode = mpiNode.get("master_plans_services");
		JsonNode mpProdNode = mpiNode.get("master_plan_product_fields");
		
		
		//Billing System Supp Plan Instance
		JsonNode suppNode = mpiNode.get("supp_plans_info");
        Iterator<JsonNode> suppElementsNode = suppNode.elements();
        while(suppElementsNode.hasNext()){
            mpi.getSuppPlans().add(mapBillingSystemSuppPlanInstance((JsonNode)suppElementsNode.next()));
        }

		//Master Plan Product Fields
        Iterator<JsonNode> mpProdElementNode = mpProdNode.elements();
        while(mpProdElementNode.hasNext()){
            mpi.getMasterPlanProductFields().add(mapMasterPlanProductField((JsonNode)mpProdElementNode.next()));
            //mpProdElementNode.next();
        }

		/*for(MasterPlanProductField pf : mpi.getMasterPlanProductFields()){
			if(pf.getFieldName().equals("ACTIVE_ENTITLEMENTS")){
				mpi.getEntitlements().add(new Entitlement(){{ setActiveEntitlements(pf.getFieldValue());}});
				mpi.setCurrentEntitlement(pf.getFieldValue());
			}
			else if(pf.getFieldName().equals("HIBERNATION_ENTITLEMENTS")){
				mpi.getEntitlements().add(new Entitlement(){{ setHibernationEntitlements(pf.getFieldValue());}});
				mpi.setCurrentEntitlement(pf.getFieldValue());
			}
			else if(pf.getFieldName().equals("PENDING_CLOSE_ENTITLEMENTS")){
				mpi.getEntitlements().add(new Entitlement(){{ setPendingCloseEntitlements(pf.getFieldValue());}});
				mpi.setCurrentEntitlement(pf.getFieldValue());
			}
			else if(pf.getFieldName().equals("PREPARATION_ENTITLEMENTS")){
				mpi.getEntitlements().add(new Entitlement() {{ setPreparationEntitlements(pf.getFieldValue());}});
				mpi.setCurrentEntitlement(pf.getFieldValue());
			}
			else if(pf.getFieldName().equals("SUSPENDED_ENTITLEMENTS")){
				mpi.getEntitlements().add(new Entitlement() {{ setSuspendedEntitlements(pf.getFieldValue());}} );
				mpi.setCurrentEntitlement(pf.getFieldValue());
			}
		}*/
		
		//Master Plan Instance Fields
		JsonNode mpInstNode = mpiNode.get("mp_plan_inst_fields");
        Iterator<JsonNode> mpInstElementNode = mpInstNode.elements();
        while(mpInstElementNode.hasNext()){
            mpi.getMasterPlanInstanceFields().add(mapMasterPlanInstanceFields((JsonNode)mpInstElementNode.next()));
            //mpInstElementNode.next();
        }

		for(MasterPlanInstanceField mpiField : mpi.getMasterPlanInstanceFields()){
			if(mpiField.getPlanInstanceFieldName().equals("BILL_TO_ADDRESS_IDS"))
				mpi.setBillingAddressIds(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("BUSINESS_UNIT"))
				mpi.setBusinessUnit(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("MEDIA_INCLUDED"))
				mpi.setMediaIncluded(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("MEDIA_USED"))
				mpi.setMediaUsed(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("CONTINUATION_RATE"))
				mpi.setContinuationRate(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("CONTRACT_CUSTOMER"))
				mpi.setContractCustomer(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("CONTRACT_CUSTOMER_ADDRESS"))
				mpi.setContractCustomerAddress(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("CONTRACT_CUSTOMER_CONTACT"))
				mpi.setContractCustomerContact(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("CONTRACT_TERM"))
				mpi.setContractTerm(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("COUNTRY_OF_ISSUER"))
				mpi.setCountryOfIssuer(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("EFFECTIVE_DATE"))
				mpi.setEffectiveDate(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("HIBERNATION_RATE"))
				mpi.setHibernationRate(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("OPERATING_UNIT_NAME"))
				mpi.setOperatingUnitName(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("PRIMARY_SERVICE_SITE"))
				mpi.setPrimaryServiceSite(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("PRIMARY_REP_ID"))
				mpi.setPrimaryRepId(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("PRIMARY_REP_NAME"))
				mpi.setPrimaryRepName(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("PRODUCT_TYPE"))
				mpi.setProductType(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("PROJECT_CREATION_DATE"))
				mpi.setProjectCreationDate(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("PROJECT_PHASE"))
				mpi.setProjectPhase(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("SALESREP_SPLIT_AMOUNT"))
				mpi.setSalesRepSplitAmount(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("REVENUE_SITE"))
				mpi.setRevenueSite(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("SALESFORCE_PROJECT_ID"))				
				mpi.setSalesforceProjectId(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("SPLIT_BILLING_ACCOUNTS"))
				mpi.setSplitBillingAccounts(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("PROCESSED_FOR_CONTRACT_MINIMUM"))
				mpi.setProcessedForContractMinimum(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("SPLIT_BILLING_INV_TEXT"))
				mpi.setSplitBillingInvText(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("SALESFORCE_PROJECT_NAME"))
				mpi.setSalesforceProjectName(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("HISTORICAL_EFFECTIVE_DATE"))
				mpi.setHistoricalEffectiveDate(mpiField.getPlanInstanceFieldValue());
			else if(mpiField.getPlanInstanceFieldName().equals("HIBERNATE_OUT_DATE"))
				mpi.setHibernateOutDate(mpiField.getPlanInstanceFieldValue());
		}
		//Master Plan Service Item
		mpi.getMasterPlanServices().add(mapMasterPlanServiceItem(mpiServiceNode));
		return mpi;
	}
	
	//Map Supp Field
	private static SuppField mapSuppField(JsonNode suppFieldNode){
		SuppField suppField = new SuppField();
		suppField.setSuppFieldName(suppFieldNode.get("supp_field_name").asText());
		suppField.setSuppFieldValue(suppFieldNode.get("supp_field_value").asText());
		return suppField;
	}
	
	//Map Master Plan Product Field
	private static MasterPlanProductField mapMasterPlanProductField(JsonNode mpProdNode){
		MasterPlanProductField mpProdField = new MasterPlanProductField();
		mpProdField.setFieldName(mpProdNode.get("field_name").asText());
		mpProdField.setFieldValue(mpProdNode.get("field_value").asText());
		return mpProdField;
	}
	
	//Map Master Plan Instance Field
	private static MasterPlanInstanceField mapMasterPlanInstanceFields(JsonNode mpInstNode){
		MasterPlanInstanceField mpInstField = new MasterPlanInstanceField();
		mpInstField.setPlanInstanceFieldName(mpInstNode.get("plan_instance_field_name").asText());
		mpInstField.setPlanInstanceFieldValue(mpInstNode.get("plan_instance_field_value").asText());
		return mpInstField;
	}
	
	//Map Master Plan Service Item
	private static MasterPlanServiceItem mapMasterPlanServiceItem(JsonNode mpiServiceNode){
	    logger.warn("TODO Remove - Is the mpiServiceNode null? " + mpiServiceNode.isNull());

		MasterPlanServiceItem mpiItem = new MasterPlanServiceItem();

		if (!mpiServiceNode.isNull()) {
			mpiItem.setClientSerivceId(mpiServiceNode.get("client_service_id").asText());
			mpiItem.setClientServiceLocationId(mpiServiceNode.get("client_svc_location_id").asText());
			mpiItem.setDestinationContactNumber(mpiServiceNode.get("dest_contact_no").asText());
			mpiItem.setServiceLocationNumber(mpiServiceNode.get("svc_location_no").asText());
			mpiItem.setServiceNumber(mpiServiceNode.get("service_no").asText());
		}

		return mpiItem;
	}
	
	//Map Billing System Contact
	private static BillingSystemContact mapBillingSystemContact(JsonNode contactNode){
		BillingSystemContact sysContact = new BillingSystemContact();
		sysContact.setAddress1(contactNode.get("stmt_address1").asText());
		sysContact.setAddress2(contactNode.get("stmt_address2").asText());
		sysContact.setAddress3(contactNode.get("stmt_address3").asText());
		sysContact.setCountry(contactNode.get("stmt_country").asText());
		sysContact.setEmail(contactNode.get("stmt_email").asText());
		sysContact.setLastName(contactNode.get("stmt_last_name").asText());
		sysContact.setLocality(contactNode.get("stmt_locality").asText());
		sysContact.setFirstName(contactNode.get("stmt_first_name").asText());
		sysContact.setCompanyName(contactNode.get("stmt_company_name").asText());
		sysContact.setCity(contactNode.get("stmt_city").asText());
		sysContact.setPhone(contactNode.get("stmt_phone").asText());
		sysContact.setPostalCode(contactNode.get("stmt_postal_cd").asText());
		sysContact.setStateProvince(contactNode.get("stmt_state_prov").asText());
		return sysContact;
	}
	
	//Map Billing System Supp Plan Instance
	private static BillingSystemSuppPlanInstance mapBillingSystemSuppPlanInstance(JsonNode suppNode){
		BillingSystemSuppPlanInstance suppPlanInstance = new BillingSystemSuppPlanInstance();
		suppPlanInstance.setClientPlanId(suppNode.get("client_supp_plan_id").asText());
		suppPlanInstance.setAltRateScheduleNumber(suppNode.get("alt_rate_schedule_no").asText());
		suppPlanInstance.setClientParentPlanInstanceId(suppNode.get("client_parent_plan_instance_id").asText());
		suppPlanInstance.setClientSuppPlanInstanceId(suppNode.get("client_supp_plan_instance_id").asText());
		suppPlanInstance.setLastArrearsBillThroughDate(suppNode.get("last_arrears_bill_thru_date").asText());
		suppPlanInstance.setLastBillDate(suppNode.get("last_bill_date").asText());
		suppPlanInstance.setLastBillThroughDate(suppNode.get("last_bill_thru_date").asText());
		suppPlanInstance.setNextBillDate(suppNode.get("next_bill_date").asText());
		suppPlanInstance.setParentPlanInstanceNumber(suppNode.get("parent_plan_instance_no").asText());
		suppPlanInstance.setPlanDate(suppNode.get("plan_date").asText());
		suppPlanInstance.setPlanDeprovisionDate(suppNode.get("plan_deprovisioned_date").asText());
		suppPlanInstance.setPoNumber(suppNode.get("po_num").asText());
		suppPlanInstance.setRecurringBillingInterval(suppNode.get("recurring_billing_interval").asText());
		suppPlanInstance.setRolloverPlanStatus(suppNode.get("rollover_plan_status").asText());
		suppPlanInstance.setRolloverPlanStatusDuration(suppNode.get("rollover_plan_status_duration").asText());
		suppPlanInstance.setRolloverPlanStatusUOMCd(suppNode.get("rollover_plan_status_uom_cd").asText());
		suppPlanInstance.setStatusDate(suppNode.get("status_date").asText());
		suppPlanInstance.setSuppPlanInstanceDescription(suppNode.get("supp_plan_instance_description").asText());
		suppPlanInstance.setSuppPlanInstanceNumber(suppNode.get("supp_plan_instance_no").asText());
		suppPlanInstance.setSuppPlanInstanceStatus(suppNode.get("supp_plan_instance_status").asText());
		suppPlanInstance.setSuppPlanInstanceStatusCd(suppNode.get("supp_plan_instance_status_cd").asText());
		suppPlanInstance.setSuppPlanNumber(suppNode.get("supp_plan_no").asText());
		suppPlanInstance.setSuppPlanUnits(suppNode.get("supp_plan_units").asText());
		suppPlanInstance.setUsageBillingInterval(suppNode.get("usage_billing_interval").asText());

		JsonNode suppSvcNode = suppNode.get("supp_plans_services");

        Iterator<JsonNode> suppSvcElementsNode = suppSvcNode.elements();
        while(suppSvcElementsNode.hasNext()){
            suppPlanInstance.getSuppPlanServices().add(mapSuppPlanServiceItem(suppSvcElementsNode.next()));
        }

		return suppPlanInstance;
	}
	
	//Map Supp Plan Service Item
	private static SuppPlanServiceItem mapSuppPlanServiceItem(JsonNode suppNode){
	    logger.warn("TODO Remove is suppPlansServices null?" + (suppNode.isNull()));
		SuppPlanServiceItem supp = new SuppPlanServiceItem();
	    if (!suppNode.isNull()) {
			supp.setClientServiceId(suppNode.get("client_service_id").asText());
			supp.setClientServiceLocationId(suppNode.get("client_svc_location_id").asText());
			supp.setDestinationContactNumber(suppNode.get("dest_contact_no").asText());
			supp.setServiceLocationNumber(suppNode.get("svc_location_no").asText());
			supp.setServiceNumber(suppNode.get("service_no").asText());
		}

		return supp;
	}
	
	//Map Billing Groups Info
	private static void mapBillingGroup(JsonNode bgNode, BillingSystemBillingGroup billingGroup){
		billingGroup.setName(bgNode.get("billing_group_name").asText());
		billingGroup.setStatementTemplate(bgNode.get("statement_template").asText());
		billingGroup.setCreditMemoTemplate(bgNode.get("credit_memo_template").asText());
		billingGroup.setCreditNoteTemplate(bgNode.get("credit_note_template").asText());
		billingGroup.setRebillTemplate(bgNode.get("rebill_template").asText());
		billingGroup.setBillingGroupNumber(bgNode.get("billing_group_no").asText());
		billingGroup.setBillingGroupDescription(bgNode.get("billing_group_description").asText());
	}

	/**
	 * Called from the createCanonicalModel flow
	 *
	 * @param jsonResponse
	 * @return
	 */
	public static BilledParty deserializeResponse(String jsonResponse, BilledParty billedParty){
		logger.warn("MPI: {}", billedParty.getBillingSystemMasterPlanId());

		JsonNode rootNode;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


		//projectModel.getCrossRefs().findMPI()
		try {
			rootNode = mapper.readValue(jsonResponse, JsonNode.class);
			//Supp Field
			JsonNode suppFieldNode = rootNode.get("supp_field");

			Iterator<JsonNode> suppFieldElementsNode = suppFieldNode.elements();
			while(suppFieldElementsNode.hasNext()){
				billedParty.getSuppFields().add(mapSuppField(suppFieldElementsNode.next()));
			}

			for(SuppField sf : billedParty.getSuppFields()){
				if(sf.getSuppFieldName().equals("INVOICE_FOOTER_LEFT"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setInvoiceFooterLeft(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("INVOICE_FOOTER_RIGHT"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setInvoiceFooterRight(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("INVOICE_HEADER_LEFT"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setInvoiceHeaderLeft(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("INVOICE_HEADER_RIGHT"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setInvoiceHeaderRight(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("INVOICE_TERM_VERBIAGE"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setInvoiceTermVerbiage(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("LEGAL_ENTITY"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setLegalEntity(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("LEGAL_ENTITY_NAME"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setLegalEntityName(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("ORACLE_ID"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setOracleId(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("ORACLE_NUMBER"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setOracleNumber(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("SFDC_ID"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setSfdcId(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("ACTIVE_LABEL"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setActiveLabel(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("CLOSE_DATE"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setCloseDate(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("HIBERNATE_DATE"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setHibernateDate(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("SUSPENDED_DATE"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setSuspendedDate(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("PENDING_CLOSE_DATE"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setPendingCloseDate(sf.getSuppFieldValue());
				else if(sf.getSuppFieldName().equals("HOSTING_LABEL"))
					billedParty.getBillingSystemAccount().getBillingSystemMasterPlanInstance().setHostingLabel(sf.getSuppFieldValue());
				
			}

			//TODO This might not be correct, need to look at it more. It is my understanding that many master plans
			//could be on the response from aria, so we would need to match up the correct acctNo for mapping.
			//... but I could be wrong
			Iterator<JsonNode> mpiNodes = rootNode.get("master_plans_info").elements();
			while(mpiNodes.hasNext()){

				JsonNode mpiNode = mpiNodes.next();

				//Iterate through each MasterPlan and find the one this billedParty is tied to
				if (mpiNode.get("client_master_plan_instance_id").asText().equals(billedParty.getBillingSystemMasterPlanId())) {

					//billedParty.getSuppFields().add(mapSuppField((JsonNode)suppFieldElementsNode.next()));

					//Billing System Master Plan Instance
					billedParty.getBillingSystemAccount().setBillingSystemMasterPlanInstance(mapBillingSystemMasterPlanInstance(mpiNode));

					String billingGroupNumber = mpiNode.get("billing_group_no").asText();

					Iterator<JsonNode> bgNodes = rootNode.get("billing_groups_info").elements();

					while (bgNodes.hasNext()) {
						JsonNode bgNode = bgNodes.next();
						//We are now at the right billingGroup for this MPI
						if (bgNode.get("billing_group_no").asText().equals(billingGroupNumber)) {
							//Billing System Billing Group
							billedParty.getBillingSystemAccount().getContacts().add(mapBillingSystemContact(bgNode));
							mapBillingGroup(bgNode, billedParty.getBillingSystemAccount().getBillingGroup());
						}
					}
				}
				billedParty.getBillingSystemAccount().setBillingSystemDunningGroupId(mpiNode.get("dunning_group_no").asText());
			}

			//TODO FIXME How do we map this? Is this needed? We might get this from MDR and not Aria
			String accountNumber = rootNode.get("acct_no").asText();

			billedParty.getBillingSystemAccount().setCompanyName(rootNode.get("company_name").asText());

			//Billing System Accounts
			//billedParty.getBillingSystemAccount().getContacts().add(mapBillingSystemContact(rootNode));
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return billedParty;
		
		
	}

}
