package com.oracle.hrb.zhzw.service;

import com.oracle.hrb.zhzw.bean.User;
import com.oracle.hrb.zhzw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    public boolean addUser(User user) {
        User u = userDao.findByName(user.getName());
        if(u != null) {
            return false;
        }
        user.setId(UUID.randomUUID().toString());
        userDao.add(user);
        return true;
    }
    @Transactional
    public void deleteUser(String id) {
        userDao.delete(id);
    }
    @Transactional
    public boolean updateUser(User user) {
        User u = userDao.findByName(user.getName());
        if(u != null && !u.getId().equals(user.getId())) {
            return false;
        }
        userDao.update(user);
        return true;
    }
    @Transactional
    public List<User> findAllUser(User user) {
        return userDao.findAll(user);
    }

}
