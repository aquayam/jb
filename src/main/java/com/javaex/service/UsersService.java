package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UsersDao;
import com.javaex.vo.UsersVo;

@Service
public class UsersService {
	
	@Autowired
	UsersDao usersDao;
	@Autowired
	BlogDao blogDao;

	public UsersVo login(String id, String password) {
		return usersDao.login(id, password);
	}

	public void join(UsersVo usersVo) {
		usersDao.join(usersVo);
		int userNo = usersDao.getUserNo(usersVo.getUserNo());
		blogDao.insertBlog(userNo);
	}

	public boolean idCheck(String id) {
		boolean result;
		UsersVo usersVo = usersDao.idCheck(id);
		if(usersVo != null) {
			result = false;
		}
		else {
			result = true;
		}
		return result;
	}
	
}
