package com.runfeng.hibernate.InformationEntity;

import org.hibernate.annotations.Parent;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 帝 on 2017/4/2.
 */
@Entity
@Table(name = "personalinfo_table")
public class PersonalInfo {
    @Id
    private int eid;
    private BasicInfo basicInfo;
    private Contract contract;
    private Education education;


    public PersonalInfo(int eid, BasicInfo basicInfo, Contract contract, Education education) {
        this.eid = eid;
        this.basicInfo = basicInfo;
        this.contract = contract;
        this.education = education;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public BasicInfo getBasicInfo() {
        return basicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.basicInfo = basicInfo;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

}
