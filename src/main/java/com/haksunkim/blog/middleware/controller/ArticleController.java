package com.haksunkim.blog.middleware.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haksunkim.blog.middleware.domain.Article;
import com.haksunkim.blog.middleware.repository.ArticleRepository;

@Controller
public class ArticleController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@RequestMapping(value="/articles", method=RequestMethod.GET)
	@ResponseBody
	public List<Article> getArticles() {
		return (List<Article>) articleRepository.findAll();
	}
	
	@RequestMapping(value="/articles", method={RequestMethod.POST,RequestMethod.PUT})
	@ResponseBody
	public Article saveArticle(@RequestBody Article article) {
		return articleRepository.save(article);
	}
	
	@RequestMapping(value="/articles/:id", method=RequestMethod.DELETE)
	@ResponseBody
	public Article deleteArticle(@PathVariable("id") Long id, @RequestParam("user_id") Long user_id) {
		Article article = articleRepository.findOne(id);
		article.setDeletedAt(new Timestamp(new Date().getTime()));
		article.setDeletedBy(user_id);
		
		return articleRepository.save(article);
	}
}
