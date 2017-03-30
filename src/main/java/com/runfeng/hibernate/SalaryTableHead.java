package com.runfeng.hibernate;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by lenovo on 2017/3/29.
 */
@Entity
@Table(name = "table_head")
public class SalaryTableHead {
    private String eid;
    private String name;
    private String department;
    private String date;
    private String salary;
    private String basicSalary;
    private String checkSalary;
    private String floatingSalary;
    private String festivalSalary;
    private String holidaySalary;
    private String nightSalary;
    private String subsidySalary;
    private String totalSalary;

    public SalaryTableHead(String eid, String name, String department, String date,
                           String salary, String basicSalary, String checkSalary, String floatingSalary,
                           String festivalSalary, String holidaySalary, String nightSalary, String subsidySalary,
                           String totalSalary) {
        this.eid = eid;
        this.name = name;
        this.department = department;
        this.date = date;
        this.salary = salary;
        this.basicSalary = basicSalary;
        this.checkSalary = checkSalary;
        this.floatingSalary = floatingSalary;
        this.festivalSalary = festivalSalary;
        this.holidaySalary = holidaySalary;
        this.nightSalary = nightSalary;
        this.subsidySalary = subsidySalary;
        this.totalSalary = totalSalary;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getCheckSalary() {
        return checkSalary;
    }

    public void setCheckSalary(String checkSalary) {
        this.checkSalary = checkSalary;
    }

    public String getFloatingSalary() {
        return floatingSalary;
    }

    public void setFloatingSalary(String floatingSalary) {
        this.floatingSalary = floatingSalary;
    }

    public String getFestivalSalary() {
        return festivalSalary;
    }

    public void setFestivalSalary(String festivalSalary) {
        this.festivalSalary = festivalSalary;
    }

    public String getHolidaySalary() {
        return holidaySalary;
    }

    public void setHolidaySalary(String holidaySalary) {
        this.holidaySalary = holidaySalary;
    }

    public String getNightSalary() {
        return nightSalary;
    }

    public void setNightSalary(String nightSalary) {
        this.nightSalary = nightSalary;
    }

    public String getSubsidySalary() {
        return subsidySalary;
    }

    public void setSubsidySalary(String subsidySalary) {
        this.subsidySalary = subsidySalary;
    }

    public String getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(String totalSalary) {
        this.totalSalary = totalSalary;
    }
}
