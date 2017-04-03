package com.runfeng.hibernate.InformationEntity;

import org.hibernate.annotations.Parent;

import javax.persistence.*;

/**
 * Created by 帝 on 2017/4/2.
 */
@Entity
@Table(name = "personalinfo_table")
public class PersonalInfo {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "eid",
            column = @Column(name = "eid")),
            @AttributeOverride(name = "name",
            column = @Column(name = "name"))
    })
    private MainID mainID;
    private BasicInfo basicInfo;
    private PositionInfo positionInfo;
    private Education education;
    private Contract contract;

    public PersonalInfo() {
    }

    public PersonalInfo(MainID mainID, BasicInfo basicInfo, PositionInfo positionInfo, Education education, Contract contract) {
        this.mainID = mainID;
        this.basicInfo = basicInfo;
        this.positionInfo = positionInfo;
        this.education = education;
        this.contract = contract;
    }

    public MainID getMainID() {
        return mainID;
    }

    public void setMainID(MainID mainID) {
        this.mainID = mainID;
    }

    public PositionInfo getPositionInfo() {
        return positionInfo;
    }

    public void setPositionInfo(PositionInfo positionInfo) {
        this.positionInfo = positionInfo;
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
