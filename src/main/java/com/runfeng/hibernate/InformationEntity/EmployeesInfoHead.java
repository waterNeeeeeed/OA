package com.runfeng.hibernate.InformationEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by lenovo on 2017/4/3.
 */
public class EmployeesInfoHead {
    private String eid;
    private String name;
    private String sex;
    private String identification;
    private String telephone;
    private String nativeplace;

    private String workid;
    private String department;
    private String post;
    private String position;
    private String positionstate;

    private String educationalbackground;
    private String school;
    private String schoolform;
    private String major;

    private String contractid;
    private String contractfirstsigndate;
    private String contractstartdate;
    private String contractenddate;
    private String contractstate;

    public EmployeesInfoHead() {
    }

    public EmployeesInfoHead(String eid,
                             String name, String sex, String identification, String telephone, String nativeplace,
                             String workid, String department, String post, String position, String positionstate,
                             String educationalbackground, String school, String schoolform, String major,
                             String contractid, String contractfirstsigndate, String contractstartdate, String contractenddate, String contractstate) {
        this.eid = eid;
        this.name = name;
        this.sex = sex;
        this.identification = identification;
        this.telephone = telephone;
        this.nativeplace = nativeplace;
        this.workid = workid;
        this.department = department;
        this.post = post;
        this.position = position;
        this.positionstate = positionstate;
        this.educationalbackground = educationalbackground;
        this.school = school;
        this.schoolform = schoolform;
        this.major = major;
        this.contractid = contractid;
        this.contractfirstsigndate = contractfirstsigndate;
        this.contractstartdate = contractstartdate;
        this.contractenddate = contractenddate;
        this.contractstate = contractstate;
    }

    public String getContractfirstsigndate() {
        return contractfirstsigndate;
    }

    public void setContractfirstsigndate(String contractfirstsigndate) {
        this.contractfirstsigndate = contractfirstsigndate;
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

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
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

    public String getEducationalbackground() {
        return educationalbackground;
    }

    public void setEducationalbackground(String educationalbackground) {
        this.educationalbackground = educationalbackground;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolform() {
        return schoolform;
    }

    public void setSchoolform(String schoolform) {
        this.schoolform = schoolform;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getContractstartdate() {
        return contractstartdate;
    }

    public void setContractstartdate(String contractstartdate) {
        this.contractstartdate = contractstartdate;
    }

    public String getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(String contractenddate) {
        this.contractenddate = contractenddate;
    }

    public String getContractstate() {
        return contractstate;
    }

    public void setContractstate(String contractstate) {
        this.contractstate = contractstate;
    }
}
