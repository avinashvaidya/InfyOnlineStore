package com.infy.dao;

import java.util.List;

import com.infy.vo.ProductDetailsVo;

public interface ProductDetailsDao {

	public List<ProductDetailsVo> findProducts() throws Exception;

}
