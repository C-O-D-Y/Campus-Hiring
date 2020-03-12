package com.campushiring.controllers;

import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.campushiring.entity.User;
import com.campushiring.repositories.UserRepo;

@Controller
public class UsersController {

	@Autowired
	UserRepo userRepo;

	Logger LOG;

	public UsersController() {

		LOG = LoggerFactory.getLogger(UsersController.class);
	}

	@PutMapping(path = "/sc/setUser", consumes = { "application/json" })
	@ResponseBody()
	public User setOrUpdateUser(@RequestBody User userInfo) {
		try {
			userRepo.save(userInfo);
			LOG.info("User had Created or updated");
		} catch (Exception e) {

		}
		return userInfo;
	}

	@GetMapping(path = "/sc/getAllUsers")
	@ResponseBody()
	public ArrayList<User> getAllUsers() {

		ArrayList<User> allUsers = new ArrayList<User>();

		Iterable<User> users = userRepo.findAll();
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			allUsers.add(itr.next());
		}
		return allUsers;
	}

}