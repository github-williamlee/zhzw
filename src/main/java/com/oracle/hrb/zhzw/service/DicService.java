package com.oracle.hrb.zhzw.service;

import com.oracle.hrb.zhzw.bean.Dic;
import com.oracle.hrb.zhzw.dao.DicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DicService {
    @Autowired
    private DicDao dicDao;
    @Transactional
    public void deleteDic(Dic dic) {
        dicDao.delete(dic);
    }
    @Transactional
    public List<Dic> findDicsByType(String type) {
        return dicDao.findByType(type);
    }
    @Transactional
    public boolean addDic(Dic dic) {
        List<Dic> types = dicDao.findByType(dic.getType());
        if(types != null) {
            for (Dic d : types) {
                // 1、type和name组合不能重复
                if (d.getName().equals(dic.getName())) {
                    return false;
                }
                // 2、相同type的value值不能重复
                if (d.getValue() == dic.getValue()) {
                    return false;
                }
            }
        }
        dicDao.add(dic);
        return true;
    }
    @Transactional
    public boolean updateDic(Dic dic) {
        List<Dic> types = dicDao.findByType(dic.getType());
        if(types != null) {
            for (Dic d : types) {
                if (!d.getName().equals(dic.getName()) && d.getValue() == dic.getValue()) {
                    return false;
                }
            }
        }
        dicDao.update(dic);
        return true;
    }
}
