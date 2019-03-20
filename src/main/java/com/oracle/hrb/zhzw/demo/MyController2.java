package com.oracle.hrb.zhzw.demo;

import com.oracle.hrb.zhzw.bean.Org;
import com.oracle.hrb.zhzw.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MyRequestMapping("/org")
public class MyController2 {

    @Autowired
    private OrgService service;
    @MyRequestMapping(value = "/", method = "POST")
    public String orgList() {
        System.out.println("MyController addOrg()...");
        List<Org> all = service.findAll(null);
        System.out.println(all);
        return "success";
    }
}
