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
    public void addUser(User user) {
        List<User> list = userDao.findByName(user.getName());
        if(list != null && list.size() > 0) {
            int num = 2;
            for(User u : list) {
                System.out.println(u);
                String name = u.getName();
                int index = name.lastIndexOf("-");
                if(index != -1) {
                    int n = Integer.parseInt(name.substring(index + 1));
                    if(n >= num) num = n + 1;
                }
            }
            user.setName(user.getName() + "-" + num);
        }
        user.setId(UUID.randomUUID().toString());
        userDao.add(user);
    }
    @Transactional
    public void deleteUser(String id) {
        userDao.delete(id);
    }
    @Transactional
    public boolean updateUser(User user) {
        userDao.update(user);
        return true;
    }
    @Transactional
    public List<User> findAllUser(User user) {
        return userDao.findAll(user);
    }

}
