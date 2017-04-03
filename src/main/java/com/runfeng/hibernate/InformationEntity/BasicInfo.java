package com.runfeng.hibernate.InformationEntity;

import org.hibernate.annotations.Parent;

import javax.persistence.Embeddable;

/**
 * Created by 帝 on 2017/4/2.
 */
@Embeddable
public class BasicInfo {
    private String sex;
    private String identification;
    private String telephone;
    private String nativeplace;

    @Parent
    private PersonalInfo personalInfo;

    public BasicInfo() {
    }

    public BasicInfo(String sex, String identification, String telephone, String nativeplace) {

        this.sex = sex;
        this.identification = identification;
        this.telephone = telephone;
        this.nativeplace = nativeplace;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }



    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }
}
