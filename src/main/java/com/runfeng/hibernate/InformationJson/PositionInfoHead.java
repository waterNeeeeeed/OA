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
}
