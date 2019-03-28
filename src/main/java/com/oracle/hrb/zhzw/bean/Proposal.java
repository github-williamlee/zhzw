package com.oracle.hrb.zhzw.bean;

import java.util.Date;

public class Proposal {
    private String id;//主键
    private Dic category;//类别
    private String categoryNum;//类别号
    private Dic the;//届
    private String time;//次
    private String num;//提案号
    private Dic type;//提案类型
    private String name;//案由
    private String firstSponsor;//第一提案人
    private String ranking;//名次
    private Dic politics;//党派
    private String committeeNum;//委员证号
    private String zipCode;//邮政编码
    private String phone;//联系电话
    private String unitAndPosition;//单位及职务
    private String email;//电子邮箱
    private String address;//通讯地址
    private String content;//提案内容
    private Date date;//提案日期
    private Org org;//承办单位
    private Dic status;//提案状态
    private Dic signedStatus;//签收状态
    private Date singedPeriod;//签收期限
    private Dic handing;//办理情况
    private Date deadline;//办理期限

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Dic getCategory() {
        return category;
    }

    public void setCategory(Dic category) {
        this.category = category;
    }

    public String getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(String categoryNum) {
        this.categoryNum = categoryNum;
    }

    public Dic getThe() {
        return the;
    }

    public void setThe(Dic the) {
        this.the = the;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Dic getType() {
        return type;
    }

    public void setType(Dic type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSponsor() {
        return firstSponsor;
    }

    public void setFirstSponsor(String firstSponsor) {
        this.firstSponsor = firstSponsor;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public Dic getPolitics() {
        return politics;
    }

    public void setPolitics(Dic politics) {
        this.politics = politics;
    }

    public String getCommitteeNum() {
        return committeeNum;
    }

    public void setCommitteeNum(String committeeNum) {
        this.committeeNum = committeeNum;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUnitAndPosition() {
        return unitAndPosition;
    }

    public void setUnitAndPosition(String unitAndPosition) {
        this.unitAndPosition = unitAndPosition;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Org getOrg() {
        return org;
    }

    public void setOrg(Org org) {
        this.org = org;
    }

    public Dic getStatus() {
        return status;
    }

    public void setStatus(Dic status) {
        this.status = status;
    }

    public Dic getSignedStatus() {
        return signedStatus;
    }

    public void setSignedStatus(Dic signedStatus) {
        this.signedStatus = signedStatus;
    }

    public Date getSingedPeriod() {
        return singedPeriod;
    }

    public void setSingedPeriod(Date singedPeriod) {
        this.singedPeriod = singedPeriod;
    }

    public Dic getHanding() {
        return handing;
    }

    public void setHanding(Dic handing) {
        this.handing = handing;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
