package com.runfeng.hibernate.InformationEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lenovo on 2017/3/27.
 */

public class EmployeeInfo {
    private int eid;
    private String name;
    private String sex;
    private String identification;
    private String telephone;
    private String nativeplace;

    private int workid;
    private String department;
    private String post;
    private String position;
    private String positionstate;

    private String educationalbackground;
    private String school;
    private String schoolform;
    private String major;

    private String contractid;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    private Date contractfirstsigndate;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    private Date contractstartdate;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    private Date contractenddate;
    private String contractstate;

    public EmployeeInfo() {
    }

    public EmployeeInfo(MainID mainID, BasicInfo basicInfo, PositionInfo positionInfo,
                        Contract contract, Education education) {
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

        if (positionInfo != null){
            this.workid = positionInfo.getWorkid();
            this.department = positionInfo.getDepartment();
            this.post = positionInfo.getPost();
            this.position = positionInfo.getPosition();
            this.positionstate = positionInfo.getPositionstate();
        }

        if (education != null){
            this.educationalbackground = education.getEducationalbackground();
            this.school = education.getSchool();
            this.schoolform = education.getSchoolform();
            this.major = education.getMajor();
        }

        if (contract != null){
            this.contractid = contract.getContractid();
            this.contractfirstsigndate = contract.getContractfirstsigndate();
            this.contractstartdate = contract.getContractstartdate();
            this.contractenddate = contract.getContractenddate();
            this.contractstate = contract.getContractstate();

        }
    }

    public Date getContractfirstsigndate() {
        return contractfirstsigndate;
    }

    public void setContractfirstsigndate(Date contractfirstsigndate) {
        this.contractfirstsigndate = contractfirstsigndate;
    }

    public int getWorkid() {
        return workid;
    }

    public void setWorkid(int workid) {
        this.workid = workid;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public Date getContractstartdate() {
        return contractstartdate;
    }

    public void setContractstartdate(Date contractstartdate) {
        this.contractstartdate = contractstartdate;
    }

    public Date getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(Date contractenddate) {
        this.contractenddate = contractenddate;
    }

    public String getSchoolform() {
        return schoolform;
    }

    public void setSchoolform(String schoolform) {
        this.schoolform = schoolform;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
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


    public String getContractstate() {
        return contractstate;
    }

    public void setContractstate(String contractstate) {
        this.contractstate = contractstate;
    }

    public String getPositionstate() {
        return positionstate;
    }

    public void setPositionstate(String positionstate) {
        this.positionstate = positionstate;
    }
}
/*
* var informationTableHead ={
    eid:"EID", name:"姓名", sex:"性别",
    department:"部门", position:"职务",
    telephone:"电话", identification :"身份证号", nativeplace:"籍贯",
    educationalbackground:"学历", school:"学校", major:"主修",
    contractid:"合同编号", contractstartdate:"合同开始日期", contractenddate:"合同结束日期", contractstate:"合同状态",
    positionstate:"岗位状态"
};
* */