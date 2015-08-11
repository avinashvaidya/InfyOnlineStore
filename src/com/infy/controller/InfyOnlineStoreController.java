/**
 * 
 */
package com.infy.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.domain.LocationDetaUIResponse;
import com.infy.domain.ProductDetailsUIResponse;
import com.infy.domain.UserDetails;
import com.infy.domain.UserRegistrationUIResponse;

/**
 * @author AvinashVaidya
 *
 */
@RestController
@RequestMapping("/ProductStore")
public interface InfyOnlineStoreController {

	@RequestMapping(value = "/getStoreLocation", method = RequestMethod.POST)
	public @ResponseBody LocationDetaUIResponse getStoreLocation(@RequestBody String zipCode);

	@RequestMapping(value = "/getProductList", method = RequestMethod.POST)
	public @ResponseBody ProductDetailsUIResponse getProductList();

	@RequestMapping(value = "/signUpUser", method = RequestMethod.POST)
	public @ResponseBody UserRegistrationUIResponse signUpUser(@RequestBody UserDetails userDetails);

}
