/**
 * 
 */
package com.infy.domain;

import java.util.List;

/**
 * @author AvinashVaidya
 *
 */
public class ProductDetailsUIResponse extends InfyOnlineStoreResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<ProductDetails> prodDetails;

	public List<ProductDetails> getProdDetails() {
		return prodDetails;
	}

	public void setProdDetails(List<ProductDetails> prodDetails) {
		this.prodDetails = prodDetails;
	}

	

}
