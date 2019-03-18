package com.oracle.hrb.zhzw.demo;

import org.springframework.beans.factory.annotation.Autowired;

@MyRequestMapping("/org")
public class MyController {
    @Autowired
    private MyOrgService service;
    @MyRequestMapping(value = "/", method = "POST")
    public String addOrg() {
        System.out.println("MyController addOrg()...");
        service.findAll();
        return "success";
    }
}
