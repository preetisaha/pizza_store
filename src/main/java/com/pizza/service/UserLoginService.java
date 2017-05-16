package com.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.dao.UserLoginDao;
import com.pizza.domain.UserLoginDomain;

@Service
public class UserLoginService {

	@Autowired
	UserLoginDao userLoginDao;

	public UserLoginDomain checkUserLogin(String email, String password) {
		UserLoginDomain uld = userLoginDao.getLoginInfo(email);

		if (uld != null) {
			String pw = uld.getPassword();
			if (password.equals(pw)) {
				return uld;
			}
		}
		return null;
	}
}
