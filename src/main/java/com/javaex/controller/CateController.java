package com.javaex.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;



@Controller
public class CateController {
	
	@Autowired
	CategoryService cateService;
	
	@ResponseBody
	@RequestMapping("{id}/blog/cate/list")
	public List<CategoryVo> cateList(@PathVariable(value = "id") String id, @RequestParam int userNo){
		List<CategoryVo> cateList = cateService.getList(userNo);
		System.out.println(cateList.toString());
		return cateList;
	}
	
	@ResponseBody
	@RequestMapping("{id}/blog/cate/insertApi")
	public CategoryVo insertApiCate(@ModelAttribute CategoryVo cateVo) {
		
		CategoryVo caVo = cateService.insertApi(cateVo);
		System.out.println(caVo.toString());
		return caVo;
	}
	
	@ResponseBody
	@RequestMapping("{id}/blog/cate/deleteApi")
	public int deleteApiCate(@RequestBody CategoryVo cateVo) {
		
		int count = cateService.delete(cateVo);
		System.out.println(count);
		if(count != 0) { //DB삭제 성공 PK값을 보낸다.
			return cateVo.getCateNo(); 
		}else {          //실패시 -1 을 보낸다.
			return -1 ;
		}
	}
}
