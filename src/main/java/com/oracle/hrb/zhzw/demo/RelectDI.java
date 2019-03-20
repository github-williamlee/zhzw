package com.oracle.hrb.zhzw.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

public class RelectDI {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.oracle.hrb.zhzw.demo.MyController2");
        MyController2 c = (MyController2) createInstance(clazz);
        c.orgList();
    }

    public static Object createInstance(Class clazz) throws Exception {
        Object obj = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields) {
            if(field.isAnnotationPresent(Autowired.class)) {
                Object o = createInstance(field.getType());
                field.setAccessible(true);
                field.set(obj, o);
            }
        }
        return obj;
    }
}
