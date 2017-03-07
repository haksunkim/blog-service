package com.haksunkim.blog.middleware.repository;

import org.springframework.data.repository.CrudRepository;

import com.haksunkim.blog.middleware.domain.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
