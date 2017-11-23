package com.merrillcorp.enterprise.utilities;

public class MasterPlanInstanceProperty<E extends String> {
	private E prop;
	
	public MasterPlanInstanceProperty(E prop){
		this.prop = prop;
	}
	
	public Boolean isNullOrEmpty(){
		if (this.prop == null || this.prop.equals(""))
			return Boolean.TRUE;
		else
			return Boolean.FALSE;
	}
	
	public String getDirective(){
		if(this.isNullOrEmpty())
			return "1";
		else
			return "2";
	}
}
