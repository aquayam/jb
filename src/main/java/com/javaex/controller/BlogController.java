package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.PostService;
import com.javaex.vo.PostVo;

@Controller
public class BlogController {
	@Autowired
	BlogService blogService;
	@Autowired
	PostService postService;
	@Autowired
	CategoryService cateService;
	
	@RequestMapping("/{id}")
	public String blogMain(@PathVariable(value="id") String id) {
		//주소창에 아이디 들어가면 해당 블로그 나오게
		//여기에 리스트랑 내용 전부 뿌려줌?
		//카테고리(title), 포스트(title, regDate) 리스트는 전부 뿌려주고
		//가장 최신 포스트 하나 가져와서 뿌려줌
		//로그인 성공하면 블로그 페이지로 이동
		return "/blog/blog-main";
	}
	
}
