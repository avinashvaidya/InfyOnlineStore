/**
 * 
 */
package com.infy.helper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infy.domain.LocationData;
import com.infy.domain.LocationDetaUIResponse;
import com.infy.domain.ProductDetails;
import com.infy.domain.ProductDetailsUIResponse;
import com.infy.domain.UserDetails;
import com.infy.vo.ProductDetailsVo;
import com.infy.vo.UserVo;

/**
 * @author AvinashVaidya
 *
 */
public class InfyOnlineStoreMapper {

	private static Logger LOGGER = LoggerFactory.getLogger(InfyOnlineStoreMapper.class);

	/**
	 * Maps database obj list into domain obj list.
	 * 
	 * @param pcList
	 * @return pdList
	 */
	public static List<ProductDetails> createProductDetailsList(List<ProductDetailsVo> pcList) {

		List<ProductDetails> pdList = new ArrayList<ProductDetails>();
		for (ProductDetailsVo pcObj : pcList) {
			ProductDetails pdObj = new ProductDetails();
			pdObj.setAuthor(pcObj.getAuthor());
			pdObj.setBookName(pcObj.getBookName());
			pdObj.setImageUrl(pcObj.getImageUrl());
			pdObj.setIsbn(pcObj.getIsbn());
			pdObj.setPrice(pcObj.getPrice());
			pdObj.setProductId(pcObj.getProductId());
			pdObj.setPublication(pcObj.getPublication());
			pdObj.setReview1(pcObj.getReview1());
			pdObj.setReview2(pcObj.getReview2());
			pdObj.setReview3(pcObj.getReview3());
			pdObj.setReview4(pcObj.getReview4());
			pdObj.setReview5(pcObj.getReview5());

			pdList.add(pdObj);
		}
		return pdList;

	}

	/**
	 * creates productCatalog UI response.
	 * 
	 * @param pcUiResponse
	 * @param pdList
	 */
	public static void createProductCatUiResponse(ProductDetailsUIResponse pcUiResponse, List<ProductDetails> pdList) {

		pcUiResponse.setProdDetails(pdList);
	}

	/**
	 * creates location details UI response.
	 * 
	 * @param ldUiResponse
	 * @param ld
	 */
	public static void createLocationDetailsUiResponse(LocationDetaUIResponse ldUiResponse, LocationData ld) {
		ldUiResponse.setLocationDetails(ld);
	}

	/**
	 * This method is used to create user registration persistence obj.
	 * 
	 * @param userDetails
	 * @return user
	 */
	public static UserVo createUserRegistrationDbObj(UserDetails userDetails) {
		UserVo user = new UserVo();
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUserName(userDetails.getUserName());
		byte[] encryptedPass = null;
		try {
			encryptedPass = EncryptDecryptUtil.encryptString(userDetails.getPassword());
		} catch (Exception e) {
			LOGGER.error("Error in InfyOnlineStoreMapper.createUserRegistrationDbObj() " + e);
		}
		user.setPassword(String.valueOf(encryptedPass));
		user.setEmail(userDetails.getEmail());
		user.setCreateDate(new Date());
		return user;

	}

}
