package com.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.dao.EmployeeLoginDao;
import com.pizza.domain.EmployeeLoginDomain;

@Service
public class EmployeeLoginService {

	@Autowired
	EmployeeLoginDao employeeLoginDao;
	
	public EmployeeLoginDomain checkEmployeeLogin(String email, String password) {
		EmployeeLoginDomain eld = employeeLoginDao.getLoginInfo(email);

		if (eld != null) {
			String pw = eld.getPassword();
			if (password.equals(pw)) {
				return eld;
			}
		}
		return null;
	}
}
