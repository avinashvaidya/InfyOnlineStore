/**
 * 
 */
package com.infy.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.vo.UserVo;

/**
 * @author AvinashVaidya
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

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

	@Override
	public void addUser(UserVo user) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		LOGGER.info("User details saved successfully for user: " + user.getUserName());

	}

}
