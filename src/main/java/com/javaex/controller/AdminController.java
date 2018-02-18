package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.FileUploadService;
import com.javaex.service.PostService;
import com.javaex.service.UsersService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UsersVo;

@Controller
public class AdminController {

	@Autowired
	BlogService blogService;
	@Autowired
	PostService postService;
	@Autowired
	CategoryService cateService;
	@Autowired
	UsersService userService;

	@RequestMapping("{id}/blog/adminBasic")
	public String adminBasic(@PathVariable(value = "id") String id, Model model, HttpSession session) {
		// 블로그 제목, 이미지 수정하는 페이지
		UsersVo sessionUser = (UsersVo) session.getAttribute("sessionUser");
		BlogVo blogVo = blogService.getBlog(sessionUser.getUserNo());
		model.addAttribute("blogVo", blogVo);
		System.out.println(blogVo.toString());
		return "/blog/admin/blog-admin-basic";
	}

	@RequestMapping("{id}/blog/blogUpdate")
	public String adminCateForm(@PathVariable(value = "id") String id, @RequestParam("blogTitle") String blogTitle,
			@RequestParam(value = "blogFile", required = false) MultipartFile blogFile, HttpSession session) {

		UsersVo sessionUser = (UsersVo) session.getAttribute("sessionUser");
		BlogVo blogVo = new BlogVo();
		blogVo.setUserNo(sessionUser.getUserNo());
		blogVo.setBlogTitle(blogTitle);

		blogService.updateBlog(blogVo, blogFile);

		return "redirect:/" + id + "/blog/adminBasic";
	}

	@RequestMapping("{id}/blog/adminCategory")
	public String adminCategory(@PathVariable(value = "id") String id) {

		return "blog/admin/blog-admin-cate";
	}

}
