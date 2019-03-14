package com.oracle.hrb.zhzw.service;

import com.oracle.hrb.zhzw.bean.Org;
import com.oracle.hrb.zhzw.dao.OrgDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrgService {
    @Autowired
    private OrgDao orgDao;

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
    public List<Org> findAll() {
        return orgDao.findAll();
    }

    public void deleteOrg(String id) {
        orgDao.delete(id);
    }

}
