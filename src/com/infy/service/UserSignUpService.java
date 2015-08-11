/**
 * 
 */
package com.infy.service;

import com.infy.domain.UserDetails;

/**
 * @author AvinashVaidya
 *
 */
public interface UserSignUpService {

	public UserDetails registerUserDetails(UserDetails userDetails) throws Exception;

}
