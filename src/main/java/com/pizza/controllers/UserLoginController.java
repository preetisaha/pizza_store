package com.pizza.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.domain.UserLoginDomain;
import com.pizza.dto.DisplayUserDetails;
import com.pizza.dto.request.LoginRequest;
import com.pizza.exceptions.ResourceNotFoundException;
import com.pizza.service.UserLoginService;

@RestController
public class UserLoginController {

	@Autowired
	UserLoginService userLoginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public DisplayUserDetails getPersonDetails(@RequestBody LoginRequest loginRequest) {
		UserLoginDomain uld = userLoginService.checkUserLogin(loginRequest.getEmail(), loginRequest.getPassword());

		if (uld != null) {
			String name = uld.getName();
			String mail = uld.getEmail();
			int userId = uld.getUser_id();
			DisplayUserDetails displayUserDetails = new DisplayUserDetails(name, mail, userId);
			return displayUserDetails;
		} else {
			throw new ResourceNotFoundException();
		}

	}
}
