package com.runfeng.hibernate.InformationEntity;

import org.hibernate.annotations.Parent;

import javax.persistence.Embeddable;

/**
 * Created by lenovo on 2017/4/3.
 */
@Embeddable
public class PositionInfo {
    private int workid;
    private String department;
    private String post;
    private String position;
    private String positionstate;
    @Parent
    private PersonalInfo personalInfo;

    public PositionInfo() {
    }

    public PositionInfo(int workid, String department, String post, String position, String positionstate) {
        this.workid = workid;
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

    public int getWorkid() {
        return workid;
    }

    public void setWorkid(int workid) {
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
}
