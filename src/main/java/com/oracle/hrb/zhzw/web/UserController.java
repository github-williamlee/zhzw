package com.oracle.hrb.zhzw.web;

import com.oracle.hrb.zhzw.bean.Result;
import com.oracle.hrb.zhzw.bean.User;
import com.oracle.hrb.zhzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
