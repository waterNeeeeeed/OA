package com.runfeng.hibernate.InformationEntity;

/**
 * Created by lenovo on 2017/4/28.
 */
public class NumberOfEmployees {
    private int id;
    private String type;
    private int number;

    public NumberOfEmployees() {
    }

    public NumberOfEmployees(int id, String type, int number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
