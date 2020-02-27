package com.campushiring.services;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {
	
	

	@RequestMapping("/home")
	public String Login() {

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
