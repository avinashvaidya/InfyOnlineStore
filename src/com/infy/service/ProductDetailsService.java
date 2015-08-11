/**
 * 
 */
package com.infy.service;

import java.util.List;

import com.infy.domain.ProductDetails;

/**
 * @author AvinashVaidya
 *
 */
public interface ProductDetailsService {

	public List<ProductDetails> getProductCatalog() throws Exception;

}
