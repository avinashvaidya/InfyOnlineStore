package com.infy.domain;

public class LocationData {
	
	private String longitude;
	
	private String latitude;

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String toString() {

        StringBuffer buffer = new StringBuffer();
        
        buffer.append(latitude);
        buffer.append("\n");
        buffer.append(longitude);
      
        System.out.println(buffer.toString());
        return buffer.toString();
    }

	

}
