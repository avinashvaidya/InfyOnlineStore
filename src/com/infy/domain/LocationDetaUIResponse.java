/**
 * 
 */
package com.infy.domain;

/**
 * @author AvinashVaidya
 *
 */
public class LocationDetaUIResponse extends InfyOnlineStoreResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LocationData locationDetails;

	/**
	 * @return the locationDetails
	 */
	public LocationData getLocationDetails() {
		return locationDetails;
	}

	/**
	 * @param locationDetails the locationDetails to set
	 */
	public void setLocationDetails(LocationData locationDetails) {
		this.locationDetails = locationDetails;
	}
	
	

}
