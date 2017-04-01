package com.runfeng.hibernate.SalaryEntity;

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

public class SalaryTableRow {
    private int id;
    private Salary salary;

    public SalaryTableRow(Salary salary){
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
