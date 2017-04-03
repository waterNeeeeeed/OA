package com.runfeng.hibernate.InformationJson;

/**
 * Created by lenovo on 2017/4/3.
 */
public class PositionInfoHead {
    private String eid;
    private String name;
    private String workid;
    private String department;
    private String post;
    private String position;
    private String positionstate;


    public PositionInfoHead(String eid, String name, String workid, String department, String post, String position, String positionstate) {
        this.eid = eid;
        this.name = name;
        this.workid = workid;
        this.department = department;
        this.post = post;
        this.position = position;
        this.positionstate = positionstate;
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
}
