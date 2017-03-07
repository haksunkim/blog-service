package com.haksunkim.blog.middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haksunkim.blog.middleware.domain.Role;
import com.haksunkim.blog.middleware.repository.RoleRepository;

@Controller
public class RoleController {
	
	@Autowired
	RoleRepository roleRepository;
	
	@RequestMapping(value="/roles",method=RequestMethod.GET)
	@ResponseBody
	public List<Role> getRoles() {
		return (List<Role>) roleRepository.findAll();
	}
}
