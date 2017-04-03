package com.runfeng.hibernate.InformationJson;

/**
 * Created by lenovo on 2017/4/3.
 */
public class BasicInfoHead {
    private String eid;
    private String name;
    private String sex;
    private String identification;
    private String telephone;
    private String nativeplace;

    public BasicInfoHead(String eid, String name, String sex, String identification, String telephone, String nativeplace) {
        this.eid = eid;
        this.name = name;
        this.sex = sex;
        this.identification = identification;
        this.telephone = telephone;
        this.nativeplace = nativeplace;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }
}
