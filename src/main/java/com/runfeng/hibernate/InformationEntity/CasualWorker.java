package com.runfeng.hibernate.InformationEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hasee-pc on 2017/4/8.
 */
@Entity
@Table(name = "casualworker_table")
public class CasualWorker {
    private String name;
    private String sex;
    private int age;
    @Id
    private String identification;
    private String telephone;
    private String address;

    public CasualWorker() {
    }

    public CasualWorker(String name, String sex, int age, String identification, String telephone, String address) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.identification = identification;
        this.telephone = telephone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
