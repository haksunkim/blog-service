package com.haksunkim.blog.middleware.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.haksunkim.blog.middleware.domain.Role;
import com.haksunkim.blog.middleware.domain.User;
import com.haksunkim.blog.middleware.domain.View;
import com.haksunkim.blog.middleware.repository.UserRepository;
import com.haksunkim.blog.middleware.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@JsonView(View.Summary.class)
	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public List<User> findAll() {
		return userService.findAll();
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public User registerUser(@RequestBody User user) {
		if (user.getRoles() == null) {
			Set<Role> roles = new HashSet<>();
			roles.add(userService.findRoleByName("ROLE_ADMIN"));
			user.setRoles(roles);
		}
		
		return userService.save(user);
	}
	
	@JsonView(View.Summary.class)
	@RequestMapping(value="/users/:username/username", method=RequestMethod.GET)
	@ResponseBody
	public User getUserByUsername(@PathVariable("username") String username) {
		return userRepository.findByUsername(username);
	}
}
