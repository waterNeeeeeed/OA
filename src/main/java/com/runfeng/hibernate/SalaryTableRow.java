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
public class SalaryTableRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int eid;
    private String name;
    private String department;
    private Date date;
    private double salary;
    private double basicSalary;
    private double checkSalary;
    private double floatingSalary;
    private double festivalSalary;
    private double holidaySalary;
    private double nightSalary;
    private double subsidySalary;
    private double totalSalary;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getCheckSalary() {
        return checkSalary;
    }

    public void setCheckSalary(double checkSalary) {
        this.checkSalary = checkSalary;
    }

    public double getFloatingSalary() {
        return floatingSalary;
    }

    public void setFloatingSalary(double floatingSalary) {
        this.floatingSalary = floatingSalary;
    }

    public double getFestivalSalary() {
        return festivalSalary;
    }

    public void setFestivalSalary(double festivalSalary) {
        this.festivalSalary = festivalSalary;
    }

    public double getHolidaySalary() {
        return holidaySalary;
    }

    public void setHolidaySalary(double holidaySalary) {
        this.holidaySalary = holidaySalary;
    }

    public double getNightSalary() {
        return nightSalary;
    }

    public void setNightSalary(double nightSalary) {
        this.nightSalary = nightSalary;
    }

    public double getSubsidySalary() {
        return subsidySalary;
    }

    public void setSubsidySalary(double subsidySalary) {
        this.subsidySalary = subsidySalary;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
}
