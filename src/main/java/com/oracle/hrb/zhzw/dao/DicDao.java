package com.oracle.hrb.zhzw.dao;

import com.oracle.hrb.zhzw.bean.Dic;

import java.util.List;

public interface DicDao {
    void add(Dic dic);
    void delete(Dic dic);
    void update(Dic dic);
    List<Dic> findByType(String type);
}
