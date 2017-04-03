package com.runfeng.hibernate.InformationJson;

import com.runfeng.hibernate.InformationEntity.MainID;
import com.runfeng.hibernate.InformationEntity.PositionInfo;

/**
 * Created by lenovo on 2017/4/3.
 */
public class PositionInfoJson {
    private int eid;
    private String name;
    private int workid;
    private String department;
    private String post;
    private String position;
    private String positionstate;

    public PositionInfoJson() {
    }

    public PositionInfoJson(MainID mainID, PositionInfo positionInfo) {
        this.eid = mainID.getEid();
        this.name = mainID.getName();
        this.workid = positionInfo.getWorkid();
        this.department = positionInfo.getDepartment();
        this.post = positionInfo.getPost();
        this.position = positionInfo.getPosition();
        this.positionstate = positionInfo.getPositionstate();
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
