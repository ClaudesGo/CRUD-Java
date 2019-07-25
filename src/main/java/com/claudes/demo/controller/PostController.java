package com.claudes.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.claudes.demo.model.Post;
import com.claudes.demo.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/post");
		mv.addObject("posts", service.findAll());
		
		return mv;
	}
	
//	@GetMapping("/userAdd/")
//	public ModelAndView userAdd() {
//		ModelAndView mv = new ModelAndView("/postAdd");
//		
//		return mv;
//	}
	
	@GetMapping("/add/")
	public ModelAndView add(@Valid Optional<Post> optional) {
		
		ModelAndView mv = new ModelAndView("/postAdd");
		mv.addObject("post", optional);
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("/postAdd");
		
		mv.addObject("post", service.findOne(id));
		
		return mv;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		 
		service.delete(id);
		
		return findAll();
	}

	@PostMapping("/save/")
	public ModelAndView save(@Valid Post post, BindingResult result) {
		
		service.save(post);
		
		return findAll();
	}
	
	
}
