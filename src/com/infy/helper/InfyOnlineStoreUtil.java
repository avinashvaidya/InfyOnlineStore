/**
 * 
 */
package com.infy.helper;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.infy.domain.InfyOnlineStoreErrors;
import com.infy.domain.InfyOnlineStoreResponse;
import com.infy.domain.UserRegistrationUIResponse;
import com.infy.domain.UserDetails;

/**
 * @author AvinashVaidya
 *
 */
public class InfyOnlineStoreUtil {

	public static String buildAddress(String address) {
		String editedAddress = address.replaceAll(" ", "+");
		return editedAddress;
	}

	public static String formatInputAddress(String address) {

		String formattedAddress = null;
		if (!StringUtils.isEmpty(address) && address.contains(":")) {
			formattedAddress = StringUtils.substringAfter(address, ":");
		} else if (!StringUtils.isEmpty(address) && address.contains("=")) {
			formattedAddress = StringUtils.substringAfter(address, "=");
		}
		return formattedAddress;
	}

	public static void createInfyInsightErrorResponse(InfyOnlineStoreResponse uiResponse, String errorMsg) {
		List<InfyOnlineStoreErrors> errors = new ArrayList<InfyOnlineStoreErrors>();
		if (StringUtils.isEmpty(errorMsg)) {
			errors.add(new InfyOnlineStoreErrors("-1000", "Unknown Error"));
		} else {
			errors.add(new InfyOnlineStoreErrors("-1000", errorMsg));
		}
		uiResponse.setInfyInsightErrors(errors);
	}

	public static void validateGetLocationRequest(InfyOnlineStoreResponse uiResponse, String address) {
		List<InfyOnlineStoreErrors> errors = new ArrayList<InfyOnlineStoreErrors>();

		if (StringUtils.isEmpty(address)) {
			errors.add(new InfyOnlineStoreErrors("1001", "Address cannot be empty"));
		}
		uiResponse.setInfyInsightErrors(errors);
	}

	public static void validateUserRegistrationRequest(UserRegistrationUIResponse userUiresponse, UserDetails userDetails) {
		List<InfyOnlineStoreErrors> errors = new ArrayList<InfyOnlineStoreErrors>();

		if (userDetails == null) {
			errors.add(new InfyOnlineStoreErrors("2001", "User details cannot be empty"));
		}
		if (userDetails != null && StringUtils.isEmpty(userDetails.getFirstName())) {
			errors.add(new InfyOnlineStoreErrors("2002", "First Name cannot be empty"));
		}
		if (userDetails != null && StringUtils.isEmpty(userDetails.getLastName())) {
			errors.add(new InfyOnlineStoreErrors("2003", "Last Name cannot be empty"));
		}
		if (userDetails != null && StringUtils.isEmpty(userDetails.getUserName())) {
			errors.add(new InfyOnlineStoreErrors("2004", "User Name cannot be empty"));
		}
		if (userDetails != null && StringUtils.isEmpty(userDetails.getPassword())) {
			errors.add(new InfyOnlineStoreErrors("2002", "Password cannot be empty"));
		}
		if (userDetails != null && StringUtils.isEmpty(userDetails.getEmail())) {
			errors.add(new InfyOnlineStoreErrors("2002", "Email cannot be empty"));
		}
	}

}
