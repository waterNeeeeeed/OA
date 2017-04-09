package com.runfeng.hibernate.InformationJson;

import javax.persistence.Id;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class CasualWorkerHead {
    private String name;
    private String sex;
    private String age;
    private String identification;
    private String telephone;
    private String address;

    public CasualWorkerHead() {
    }

    public CasualWorkerHead(String name, String sex, String age, String identification, String telephone, String address) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
