/**
 * 
 */
package com.infy.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.vo.ProductDetailsVo;

/**
 * @author AvinashVaidya
 *
 */
@Repository
public class ProductDetailsDaoImpl implements ProductDetailsDao {

	private static Logger LOGGER = LoggerFactory.getLogger(ProductDetailsDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductDetailsVo> findProducts() throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		List<ProductDetailsVo> prodCatList = session.createQuery("from ProductDetailsVo").list();
		for (ProductDetailsVo pc : prodCatList) {
			LOGGER.debug(pc.getBookName());
		}
		return prodCatList;
	}

}
