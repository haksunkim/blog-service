package com.haksunkim.blog.middleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haksunkim.blog.middleware.domain.Tag;
import com.haksunkim.blog.middleware.repository.TagRepository;

@Controller
public class TagController {
	
	@Autowired
	TagRepository tagRepository;
	
	@RequestMapping(value="/tags",method=RequestMethod.GET)
	@ResponseBody
	public List<Tag> getTags() {
		return (List<Tag>) tagRepository.findAll();
	}
	
	@RequestMapping(value="/tags/:name/name",method=RequestMethod.GET)
	@ResponseBody
	public Tag getTagByName(@PathVariable("name") String name) {
		return tagRepository.findByName(name);
	}
}
