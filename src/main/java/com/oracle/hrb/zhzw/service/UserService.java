package com.oracle.hrb.zhzw.service;

import com.oracle.hrb.zhzw.bean.Dic;
import com.oracle.hrb.zhzw.bean.Org;
import com.oracle.hrb.zhzw.bean.User;
import com.oracle.hrb.zhzw.dao.DicDao;
import com.oracle.hrb.zhzw.dao.OrgDao;
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
    @Autowired
    private OrgDao orgDao;
    @Autowired
    private DicDao dicDao;

    @Transactional
    public User login(User user) {
        User u = userDao.findByNameAndPassword(user);
        return u;
    }

    @Transactional
    public void addUser(User user) {
        List<User> list = userDao.findByName(user.getName());
        if(list != null && list.size() > 0) {
            int num = 2;
            for(User u : list) {
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

    /**
     * 查询方式实现多对一
     */
    @Transactional
    public List<User> findAllUser2(User user) {
        List<User> users = userDao.findAll(user);
        List<Dic> genders = dicDao.findByType("性别");
        List<Dic> nations = dicDao.findByType("民族");
        List<Dic> politics = dicDao.findByType("政治面貌");
        for(User u : users) {
            Org org = orgDao.findById(u.getOrg().getId());
            u.setOrg(org);
            u.setGender(getDic(genders, u.getGender().getValue()));
            u.setNation(getDic(nations, u.getNation().getValue()));
            u.setPolitics(getDic(politics, u.getPolitics().getValue()));
        }
        return users;
    }
    /**
     * 表连接方式实现多对一
     */
    @Transactional
    public List<User> findAllUser(User user) {
        List<User> users = userDao.findAll(user);
        return users;
    }

    private Dic getDic(List<Dic> list, int value) {
        Dic dic = null;
        for(Dic d : list) {
            if(d.getValue() == value) {
                dic = d;
            }
        }
        return dic;
    }

}
