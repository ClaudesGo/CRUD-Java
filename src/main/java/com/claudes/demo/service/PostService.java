package com.claudes.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.claudes.demo.model.Post;
import com.claudes.demo.repository.IPostRepositoryDao;

@Service
public class PostService {
	
	@Autowired
	private IPostRepositoryDao repository;
	
	public List<Post> findAll() {
		return repository.findAll();
	}
	
	public @Valid Optional<Post> findOne(Long id) {
		return repository.findById(id);
	}
	
	public Post save(Post post) {
		return repository.saveAndFlush(post);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
