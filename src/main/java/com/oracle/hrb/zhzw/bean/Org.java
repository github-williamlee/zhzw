package com.oracle.hrb.zhzw.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Org {
    private String id;
    @NotNull(message = "组织结构代码不能为空")
    private String code;
    @NotNull(message = "组织结构不能为空")
    @Min(value = 4, message = "长度不能小于4")
    private String name;
    private String address;
    private String legal;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Org{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", legal='" + legal + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
