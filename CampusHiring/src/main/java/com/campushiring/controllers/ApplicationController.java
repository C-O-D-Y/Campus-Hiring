package com.campushiring.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campushiring.CampusHiring;

@Controller
public class ApplicationController {

	Logger LOG;

	public ApplicationController() {
		 LOG = LoggerFactory.getLogger(CampusHiring.class);
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/home")
	public String Login() {
		LOG.info("HOME PAGE RETURNED");
		return "Home.jsp";

	}

	@RequestMapping("/login")
	public String LoginPage() {

		return "Login.jsp";

	}

	@RequestMapping("/getuser")
	@ResponseBody
	public Principal user(Principal principal) {

		return principal;

	}
}
