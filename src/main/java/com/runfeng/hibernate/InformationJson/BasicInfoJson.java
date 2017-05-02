package com.runfeng.hibernate.InformationJson;

import com.runfeng.hibernate.InformationEntity.BasicInfo;
import com.runfeng.hibernate.InformationEntity.MainID;

/**
 * Created by lenovo on 2017/4/3.
 */
public class BasicInfoJson {
    private int eid;
    private String name;
    private String sex;
    private String identification;
    private String telephone;
    private String nativeplace;

    public BasicInfoJson() {
    }

    public BasicInfoJson(MainID mainID, BasicInfo basicInfo) {
        if (mainID != null){
            this.eid = mainID.getEid();
            this.name = mainID.getName();
        }
        if (basicInfo != null){
            this.sex = basicInfo.getSex();
            this.identification = basicInfo.getIdentification();
            this.telephone = basicInfo.getTelephone();
            this.nativeplace = basicInfo.getNativeplace();
        }

    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
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
