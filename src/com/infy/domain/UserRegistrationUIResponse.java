/**
 * 
 */
package com.infy.domain;

/**
 * @author AvinashVaidya
 *
 */
public class UserRegistrationUIResponse extends InfyOnlineStoreResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean isUserRegistered = false;
	
	private String userName;
	

	/**
	 * @return the isUserRegistered
	 */
	public boolean isUserRegistered() {
		return isUserRegistered;
	}

	/**
	 * @param isUserRegistered the isUserRegistered to set
	 */
	public void setUserRegistered(boolean isUserRegistered) {
		this.isUserRegistered = isUserRegistered;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
	
}
