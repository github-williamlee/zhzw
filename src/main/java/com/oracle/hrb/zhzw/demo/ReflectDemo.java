package com.oracle.hrb.zhzw.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.oracle.hrb.zhzw.demo.MyController");
        System.out.println(clazz);
        MyController controller = (MyController) clazz.newInstance();
        System.out.println(controller);
        //controller.addOrg();
        if(clazz.isAnnotationPresent(MyRequestMapping.class)) {
            System.out.println("类上有MyRequestMapping注解");
            MyRequestMapping ann = (MyRequestMapping) clazz.getDeclaredAnnotation(MyRequestMapping.class);
            System.out.println(ann.value());
            System.out.println(ann.method());
        }
        // 获取属性
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields) {
            System.out.println(f.getType() + " " + f.getName());
            if(f.isAnnotationPresent(Autowired.class)) {
                Object service = f.getType().newInstance();
                System.out.println(service);
                // 给私有属性赋值
                f.setAccessible(true);
                f.set(controller, service);
            }
        }
        controller.addOrg();
    }
}
