package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {
	@Autowired
	SqlSession sqlsession;

	public void insertBlog(int userNo) {
		sqlsession.insert("blog.insertBlog", userNo);
	}

	public BlogVo getBlog(int userNo) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("userNo", userNo);
		return sqlsession.selectOne("blog.getBlog", userNo);
	}

	public void updateBlog(BlogVo blogVo) {
		sqlsession.update("blog.updateBlog", blogVo);
	}
}
