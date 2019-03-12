package com.oracle.hrb.zhzw.web;

import java.util.List;

import com.oracle.hrb.zhzw.bean.Result;
import com.oracle.hrb.zhzw.bean.User;
import com.oracle.hrb.zhzw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	@RequestMapping("/addUser")
	@ResponseBody
	public Object addUser(User user) {
		Result r = new Result();
		System.out.println(user);
		//service.addUser(user.getName(), user.getPassword());
		r.setSuccess(false);
		r.setMsg("用户名已存在");
		return r;
	}
	@RequestMapping("/findAllUser")
	@ResponseBody
	public Object findAllUser() {
		Result r = new Result();
		List<User> users = service.findAllUser();
		System.out.println(users);
		r.setData(users);
		return r;
	}

}
