package com.oracle.hrb.zhzw.web;

import com.oracle.hrb.zhzw.bean.Org;
import com.oracle.hrb.zhzw.bean.Result;
import com.oracle.hrb.zhzw.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/org")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @RequestMapping(method = POST)
    public Result addOrg(Org org) {
        Result r = new Result();
        System.out.println(org);
        boolean flag = orgService.addOrg(org);
        if (flag == false) {
            r.setSuccess(false);
            r.setMsg("组织机构代码或组织机构名称已存在");
        }
        return r;
    }
    @RequestMapping(method = GET)
    public Result findOrgList() {
        Result r = new Result();
        r.setData(orgService.findAll());
        return r;
    }

}
