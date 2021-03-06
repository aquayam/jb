package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogService;
import com.javaex.service.UsersService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UsersVo;

@Controller
public class UsersController {
	
	@Autowired
	UsersService usersService;
	@Autowired
	BlogService blogService;
	
	@RequestMapping("/users/loginform")
	public String loginform() {
		return "user/loginForm";
	}
	
	@RequestMapping("/users/login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password,
						HttpSession session) {
		
		UsersVo sessionUser = usersService.login(id, password);
		
		if(sessionUser != null) {
			session.setAttribute("sessionUser", sessionUser);
			//System.out.println("로그인 성공, 로그인한 ID : " + ((UsersVo) session.getAttribute("sessionUser")).getId());
			//로그인 성공하면 블로그 메인으로 보내주는게 더 좋을듯
			return "blog/blog-main";
		}
		else {
			return "redirect:/users/loginform?result=fail";
		}
	}
	
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("sessionUser");
		session.invalidate();
		return "redirect:/main";
	}
	
	@RequestMapping("/users/joinform")
	public String joinform() {
		
		return "user/joinForm";
	}
	
	@RequestMapping("/users/join")
	public String join(@ModelAttribute UsersVo usersVo) {
		usersService.join(usersVo);
		//blogService.insertBlog(blogVo);
		return "user/joinSuccess";
	}
	
	@ResponseBody
	@RequestMapping("/users/idCheck")
	public boolean idCheck(@RequestBody UsersVo vo) {
		return usersService.idCheck(vo.getId());
	}
}
