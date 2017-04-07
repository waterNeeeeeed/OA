package com.runfeng.utils.excel.SSBasicCalculate;

/**
 * Created by lenovo on 2017/4/7.
 */
public class PersonalSalary {
    private String name;
    private String identification;
    private String personal_id;
    private Double[][] salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    public Double[][] getSalary() {
        return salary;
    }

    public void setSalary(Double[][] salary) {
        this.salary = salary;
    }
}
