package com.runfeng.hibernate.InformationEntity;

import org.hibernate.annotations.Parent;

import javax.persistence.Embeddable;

/**
 * Created by 帝 on 2017/4/2.
 */
@Embeddable
public class BasicInfo {
    private String name;
    private String sex;
    private String identification;
    private String telephone;
    private String department;
    private String post;
    private String position;
    private String positionstate;

    @Parent
    private PersonalInfo personalInfo;

    public BasicInfo() {
    }

    public BasicInfo(String name, String sex, String identification, String telephone,
                     String department, String post, String position, String positionstate) {
        this.name = name;
        this.sex = sex;
        this.identification = identification;
        this.telephone = telephone;
        this.department = department;
        this.post = post;
        this.position = position;
        this.positionstate = positionstate;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionstate() {
        return positionstate;
    }

    public void setPositionstate(String positionstate) {
        this.positionstate = positionstate;
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
