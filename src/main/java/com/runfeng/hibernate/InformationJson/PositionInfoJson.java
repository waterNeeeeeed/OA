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

    public PositionInfoJson(MainID mainID, PositionInfo positionInfo) {
        this.eid = mainID.getEid();
        this.name = mainID.getName();
        this.workid = positionInfo.getWorkid();
        this.department = positionInfo.getDepartment();
        this.post = positionInfo.getPost();
        this.position = positionInfo.getPosition();
        this.positionstate = positionInfo.getPositionstate();
    }
}
