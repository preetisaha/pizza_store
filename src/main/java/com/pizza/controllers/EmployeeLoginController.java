package com.pizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.domain.EmployeeLoginDomain;
import com.pizza.dto.request.DisplayEmployeeDetails;
import com.pizza.dto.request.LoginRequest;
import com.pizza.exceptions.ResourceNotFoundException;
import com.pizza.service.EmployeeLoginService;

@RestController
public class EmployeeLoginController {

	@Autowired
	EmployeeLoginService employeeLoginService;

	@RequestMapping(value = "/employeeLogin", method = RequestMethod.POST)
	public DisplayEmployeeDetails getEmployeeDetail(@RequestBody LoginRequest loginRequest) {
		EmployeeLoginDomain eld = employeeLoginService.checkEmployeeLogin(loginRequest.getEmail(),
				loginRequest.getPassword());

		if (eld != null) {
			String name = eld.getName();
			String mail = eld.getEmail();
			int employee_id = eld.getEmployee_id();
			DisplayEmployeeDetails displayEmployeeDetails = new DisplayEmployeeDetails(name, mail, employee_id);
			return displayEmployeeDetails;
		} else {
			throw new ResourceNotFoundException();
		}

	}
}
