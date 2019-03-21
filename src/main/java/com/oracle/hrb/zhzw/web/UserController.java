package com.oracle.hrb.zhzw.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.hrb.zhzw.bean.Result;
import com.oracle.hrb.zhzw.bean.User;
import com.oracle.hrb.zhzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public Result addUser(User user) {
        Result r = new Result();
        userService.addUser(user);
        return r;
    }
    @GetMapping
    public Result findAll(User user) {
        Result r = new Result();
        r.setData(userService.findAllUser(user));
        return r;
    }
    @GetMapping(path = "/page")
    public Result findAll(User user, Integer pageNum, Integer pageSize) {
        Result r = new Result();
        if(pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if(pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<User> page = new PageInfo(userService.findAllUser(user));
        r.setData(page);
        return r;
    }

    @DeleteMapping
    public Result deleteUser(String id) {
        Result r = new Result();
        userService.deleteUser(id);
        return r;
    }

    @PutMapping
    public Result updateUser(User user) {
        Result r = new Result();
        userService.updateUser(user);
        return r;
    }
}
