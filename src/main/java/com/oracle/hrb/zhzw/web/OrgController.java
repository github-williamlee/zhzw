package com.oracle.hrb.zhzw.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.hrb.zhzw.bean.Org;
import com.oracle.hrb.zhzw.bean.Result;
import com.oracle.hrb.zhzw.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
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
    public Result findAll(Integer pageNum, Integer pageSize) {
        Result r = new Result();
        if(pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if(pageSize == null) {
            pageSize = 10;
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Org> list = orgService.findAll();
        PageInfo<Org> orgs = new PageInfo<>(list);
        r.setData(orgs);
        return r;
    }
    @RequestMapping(method = DELETE)
    public Result deleteOrg(@RequestParam("id") String id) {
        System.out.println(id);
        Result r = new Result();
        orgService.deleteOrg(id);
        return r;
    }

}
