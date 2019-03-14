package com.oracle.hrb.zhzw.dao;

import com.oracle.hrb.zhzw.bean.Org;

import java.util.List;

public interface OrgDao {
    void add(Org org);
    void delete(String id);
    void update(Org org);
    List<Org> findAll();
    List<Org> findByCodeOrName(Org org);
}
