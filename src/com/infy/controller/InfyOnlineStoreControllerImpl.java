/**
 * 
 */
package com.infy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.domain.LocationData;
import com.infy.domain.LocationDetaUIResponse;
import com.infy.domain.ProductDetails;
import com.infy.domain.ProductDetailsUIResponse;
import com.infy.domain.UserDetails;
import com.infy.domain.UserRegistrationUIResponse;
import com.infy.helper.InfyOnlineStoreMapper;
import com.infy.helper.InfyOnlineStoreUtil;
import com.infy.service.GeoLocationService;
import com.infy.service.ProductDetailsService;
import com.infy.service.UserSignUpService;

/**
 * @author AvinashVaidya
 *
 */
@RestController
@RequestMapping("/ProductStore")
public class InfyOnlineStoreControllerImpl implements InfyOnlineStoreController {

	private static Logger LOGGER = LoggerFactory.getLogger(InfyOnlineStoreControllerImpl.class);

	@Autowired
	GeoLocationService geoLocationService;

	@Autowired
	ProductDetailsService productDetailsService;

	@Autowired
	UserSignUpService userSignUpService;

	@Override
	@RequestMapping(value = "/getStoreLocation", method = RequestMethod.POST)
	public @ResponseBody LocationDetaUIResponse getStoreLocation(@RequestBody String address) {
		LocationDetaUIResponse ldUiResponse = new LocationDetaUIResponse();

		InfyOnlineStoreUtil.validateGetLocationRequest(ldUiResponse, address);
		if (!ldUiResponse.hasErrors()) {
			LocationData locationDetails = null;
			try {
				String formattedAddress = InfyOnlineStoreUtil.formatInputAddress(address);
				locationDetails = geoLocationService.getLatlongFromGoogle(formattedAddress);
				InfyOnlineStoreMapper.createLocationDetailsUiResponse(ldUiResponse, locationDetails);
			} catch (Exception e) {
				LOGGER.error("Error in InfyOnlineStoreControllerImpl.getStoreLocation:" + e);
				String errorMsg = e.getMessage();
				InfyOnlineStoreUtil.createInfyInsightErrorResponse(ldUiResponse, errorMsg);
			}

		}
		return ldUiResponse;

	}

	@Override
	@RequestMapping(value = "/getProductList", method = RequestMethod.POST)
	public @ResponseBody ProductDetailsUIResponse getProductList() {
		ProductDetailsUIResponse productCatUiResponse = new ProductDetailsUIResponse();
		List<ProductDetails> pdList = null;
		try {
			pdList = productDetailsService.getProductCatalog();
			InfyOnlineStoreMapper.createProductCatUiResponse(productCatUiResponse, pdList);
		} catch (Exception e) {
			LOGGER.error("Error in InfyOnlineStoreControllerImpl.getProductList:" + e);
			String errorMsg = e.getMessage();
			InfyOnlineStoreUtil.createInfyInsightErrorResponse(productCatUiResponse, errorMsg);
		}

		return productCatUiResponse;

	}

	@Override
	@RequestMapping(value = "/signUpUser", method = RequestMethod.POST)
	public @ResponseBody UserRegistrationUIResponse signUpUser(@RequestBody UserDetails userDetails) {
		UserRegistrationUIResponse userUiresponse = new UserRegistrationUIResponse();
		InfyOnlineStoreUtil.validateUserRegistrationRequest(userUiresponse, userDetails);
		if (!userUiresponse.hasErrors()) {
			try {
				userSignUpService.registerUserDetails(userDetails);
				userUiresponse.setUserRegistered(true);
				userUiresponse.setUserName(userDetails.getUserName());
			} catch (Exception e) {
				LOGGER.error("Error in InfyOnlineStoreControllerImpl.signUpUser:" + e);
				String errorMsg = e.getMessage();
				InfyOnlineStoreUtil.createInfyInsightErrorResponse(userUiresponse, errorMsg);
			}
		}
		return userUiresponse;
	}

}
