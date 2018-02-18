package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {
	@Autowired
	SqlSession sqlsession;

	public List<CategoryVo> getList(int userNo) {
		return sqlsession.selectList("category.getList", userNo);
	}
	
	public CategoryVo selectCate(int cateNo) {
		return sqlsession.selectOne("category.selectCate", cateNo);
	}

	public int insertApi(CategoryVo cateVo) {
		sqlsession.insert("category.insert", cateVo);
		return cateVo.getCateNo();
	}

	public int insert(CategoryVo cateVo) {
		sqlsession.insert("category.insert", cateVo);
		return cateVo.getCateNo();
	}

	public int deleteApi(CategoryVo cateVo) {
		
		return sqlsession.delete("category.delete", cateVo);
	}
	
}
