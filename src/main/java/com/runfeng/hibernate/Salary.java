package com.runfeng.hibernate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 帝 on 2017/3/25.
 */
/*
var salaryTableHead ={
        eid:"EID", name:"姓名", department:"部门", date:"日期",
        salary:"应发工资", basicSalary:"基本工资", checkSalary:"考核工资", floatingSalary:"浮动工资",
        festivalSalary:"节日", holidaySalary:"假日", nightSalary:"夜班费", subsidySalary:"保健、补助",
        totalSalary:"合计"
        };
 */
@Entity
@Table(name="salary_table")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int eid;
    private String name;
    private String department;
    private Date date;
    private int salary;
    private int basicSalary;
    private int checkSalary;
    private int floatingSalary;
    private int festivalSalary;
    private int holidaySalary;
    private int nightSalary;
    private int subsidySalary;
    private int totalSalary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(int basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getCheckSalary() {
        return checkSalary;
    }

    public void setCheckSalary(int checkSalary) {
        this.checkSalary = checkSalary;
    }

    public int getFloatingSalary() {
        return floatingSalary;
    }

    public void setFloatingSalary(int floatingSalary) {
        this.floatingSalary = floatingSalary;
    }

    public int getFestivalSalary() {
        return festivalSalary;
    }

    public void setFestivalSalary(int festivalSalary) {
        this.festivalSalary = festivalSalary;
    }

    public int getHolidaySalary() {
        return holidaySalary;
    }

    public void setHolidaySalary(int holidaySalary) {
        this.holidaySalary = holidaySalary;
    }

    public int getNightSalary() {
        return nightSalary;
    }

    public void setNightSalary(int nightSalary) {
        this.nightSalary = nightSalary;
    }

    public int getSubsidySalary() {
        return subsidySalary;
    }

    public void setSubsidySalary(int subsidySalary) {
        this.subsidySalary = subsidySalary;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }
}
