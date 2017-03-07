package com.haksunkim.blog.middleware.repository;

import org.springframework.data.repository.CrudRepository;

import com.haksunkim.blog.middleware.domain.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findByName(String name);
}
