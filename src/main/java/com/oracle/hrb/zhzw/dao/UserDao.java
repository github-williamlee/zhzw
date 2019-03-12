package com.oracle.hrb.zhzw.dao;

import com.oracle.hrb.zhzw.bean.User;

import java.util.List;

public interface UserDao {
	void add(User user);
	List<User> findAll();
}
