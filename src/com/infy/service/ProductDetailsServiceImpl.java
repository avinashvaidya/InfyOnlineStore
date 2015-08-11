/**
 * 
 */
package com.infy.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.ProductDetailsDao;
import com.infy.domain.ProductDetails;
import com.infy.helper.InfyOnlineStoreMapper;
import com.infy.vo.ProductDetailsVo;

/**
 * @author AvinashVaidya
 *
 */
@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

	private static Logger LOGGER = LoggerFactory.getLogger(ProductDetailsServiceImpl.class);

	@Autowired
	ProductDetailsDao productCatalogDao;

	@Override
	@Transactional
	@Cacheable(value = "productCatalogCache")
	public List<ProductDetails> getProductCatalog() throws Exception {
		List<ProductDetailsVo> prodCatList = productCatalogDao.findProducts();
		List<ProductDetails> pdList = InfyOnlineStoreMapper.createProductDetailsList(prodCatList);
		return pdList;
	}

}
