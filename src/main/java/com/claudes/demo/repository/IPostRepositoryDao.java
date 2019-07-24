package com.claudes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claudes.demo.model.Post;

@Repository
public interface IPostRepositoryDao extends JpaRepository<Post, Long>{
	
	


}
