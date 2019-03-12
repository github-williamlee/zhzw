package com.oracle.hrb.zhzw.service;

import java.util.List;

import com.oracle.hrb.zhzw.bean.User;
import com.oracle.hrb.zhzw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
	private UserDao dao;
	public void addUser(String name, String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		dao.add(user);
	}
	public List<User> findAllUser() {
		return dao.findAll();
	}
}
