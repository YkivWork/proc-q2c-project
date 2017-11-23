package com.merrillcorp.enterprise.canonical.models;

import java.io.Serializable;

public class LegalName implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4566053480491742765L;
	private String legalEntityId;
	private String legalEntityName;
	
	public String getLegalEntityId() {
		return legalEntityId;
	}

	public void setLegalEntityId(String legalEntityId) {
		this.legalEntityId = legalEntityId;
	}

	public String getLegalEntityName() {
		return legalEntityName;
	}

	public void setLegalEntityName(String legalEntityName) {
		this.legalEntityName = legalEntityName;
	}

	public static LegalName spitLegalName(String legalName){
		String[] legalNameList; 
		if(legalName.isEmpty()){
			return (new LegalName() {{ setLegalEntityId("999"); setLegalEntityName("NotProvided");}});
		}
		else{
			legalNameList = legalName.split(" - ");
			return (new LegalName() {{setLegalEntityId(legalNameList[0].toString()); setLegalEntityName(legalNameList[1].toString());}});
		}
		
	}

}
