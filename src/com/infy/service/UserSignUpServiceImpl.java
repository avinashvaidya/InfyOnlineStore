/**
 * 
 */
package com.infy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.configuration.OutlookEmail;
import com.infy.dao.UserDao;
import com.infy.domain.UserDetails;
import com.infy.helper.InfyOnlineStoreMapper;
import com.infy.vo.UserVo;

/**
 * @author AvinashVaidya
 *
 */
@Service
public class UserSignUpServiceImpl implements UserSignUpService {

	private static Logger LOGGER = LoggerFactory.getLogger(ProductDetailsServiceImpl.class);

	@Autowired
	UserDao userDao;

	@Override
	@Transactional
	@OutlookEmail
	public UserDetails registerUserDetails(UserDetails userDetails) throws Exception {
		UserVo user = InfyOnlineStoreMapper.createUserRegistrationDbObj(userDetails);
		userDao.addUser(user);
		LOGGER.info("User added successfully :" + user.getUserName());
		return userDetails;
	}

}
