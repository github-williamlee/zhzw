package com.oracle.hrb.zhzw.service;

import com.oracle.hrb.zhzw.bean.Org;
import com.oracle.hrb.zhzw.dao.OrgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.callback.Callback;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class OrgService {
    @Autowired
    private OrgDao orgDao;
    @Transactional()
    public boolean addOrg(Org org) {
        List<Org> orgs = orgDao.findByCodeOrName(org);
        if(orgs.size() != 0) {
            return false;
        } else {
            org.setId(UUID.randomUUID().toString());
            orgDao.add(org);
            return true;
        }
    }
    @Transactional()
    public List<Org> findAll(String keyword) {
        return orgDao.findAll(keyword);
    }
    @Transactional()
    public void deleteOrg(String id) {
        orgDao.delete(id);
    }
    @Transactional(rollbackFor = Exception.class)
    public boolean updateOrg(Org org) throws Exception {
        List<Org> orgs = orgDao.findByCodeOrName(org);
        for(Org o : orgs) {
            if(!o.getId().equals(org.getId())) {
                if(o.getCode().equals(org.getCode()) || o.getName().equals(org.getName())) {
                    return false;
                }
            }
        }
        orgDao.update(org);
        /*
            Spring事务管理注意事项：
                1、异常不能捕获，要抛出
                2、运行时异常或错误Spring可以处理
                3、检查异常，默认Spring不处理，要想Spring处理
                    需要设置rollbackFor = Exception.class
         */
//        if(1==1) {
//            //throw new RuntimeException();
//            //int x = 1/0;
//            throw new SQLException();
//        }
        return true;
    }

    public boolean checkCodeOrPasswrod(Org org) {
        List<Org> orgs =  orgDao.findByCodeOrName(org);
        if(orgs.size() == 0) {
            return true;
        }
        for(Org o : orgs) {
            if(!o.getId().equals(org.getId())) {
                if(o.getCode().equals(org.getCode()) || o.getName().equals(org.getName())) {
                    return false;
                }
            }
        }
        return true;
    }

}
