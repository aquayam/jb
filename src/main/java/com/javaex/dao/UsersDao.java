package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UsersVo;

@Repository
public class UsersDao {
	
	@Autowired
	SqlSession sqlsession;

	public UsersVo login(String id, String password) {
		Map<String , Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);
		return sqlsession.selectOne("users.login", map);
	}

	public void join(UsersVo usersVo) {
		sqlsession.insert("users.join", usersVo);
	}

	public UsersVo idCheck(String id) {
		UsersVo usersVo = sqlsession.selectOne("users.idCheck", id);
		return usersVo;
	}

	public int getUserNo(int userNo) {
		return sqlsession.selectOne("users.getUserNo", userNo);
	}

}
