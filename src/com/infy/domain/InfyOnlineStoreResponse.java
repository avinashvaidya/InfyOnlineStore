/**
 * 
 */
package com.infy.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AvinashVaidya
 *
 */
public class InfyOnlineStoreResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<InfyOnlineStoreErrors> infyInsightErrors;


	/**
	 * @return the infyInsightErrors
	 */
	public List<InfyOnlineStoreErrors> getInfyInsightErrors() {
		return infyInsightErrors;
	}


	/**
	 * @param infyInsightErrors the infyInsightErrors to set
	 */
	public void setInfyInsightErrors(List<InfyOnlineStoreErrors> infyInsightErrors) {
		this.infyInsightErrors = infyInsightErrors;
	}
	
	public void addErros(InfyOnlineStoreErrors errors) {
		if(this.infyInsightErrors == null){
			this.infyInsightErrors = new ArrayList<InfyOnlineStoreErrors>();
			this.infyInsightErrors.add(errors);
		}else{
			this.infyInsightErrors.add(errors);
		}
	}
	
	public boolean hasErrors(){
		boolean errorStatus = false;	
		if(this.infyInsightErrors != null && this.infyInsightErrors.size() > 0){
			errorStatus = true;
		}
		return errorStatus;
	}
	

}
