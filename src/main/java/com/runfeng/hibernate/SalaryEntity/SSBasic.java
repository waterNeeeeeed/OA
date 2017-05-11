package com.runfeng.hibernate.SalaryEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.runfeng.hibernate.InformationEntity.MainID;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lenovo on 2017/4/10.
 */
/*
年表
 */
@Entity
@Table(name = "socialsecurity_basic_table")
public class SSBasic {
    @Id
    private int eid;
    private String name;
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy")
    @Temporal(TemporalType.DATE)
    private Date ssYear;
    private double ssBasicData;

    public SSBasic() {
    }

    public SSBasic(int eid, String name, Date ssYear, double ssBasicData) {
        this.eid = eid;
        this.name = name;
        this.ssYear = ssYear;
        this.ssBasicData = ssBasicData;
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

    public Date getSsYear() {
        return ssYear;
    }

    public void setSsYear(Date ssYear) {
        this.ssYear = ssYear;
    }

    public double getSsBasicData() {
        return ssBasicData;
    }

    public void setSsBasicData(double ssBasicData) {
        this.ssBasicData = ssBasicData;
    }
}
