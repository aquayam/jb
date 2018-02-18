package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;

	public List<CategoryVo> getList(int userNo) {
		return categoryDao.getList(userNo);
	}

	public  CategoryVo insertApi(CategoryVo cateVo) {
		int cateNo = categoryDao.insertApi(cateVo);
		return categoryDao.selectCate(cateNo);
	}

	public int delete(CategoryVo cateVo) {
		
		return categoryDao.deleteApi(cateVo);
	}
	
	
}
