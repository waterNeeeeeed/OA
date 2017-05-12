package com.runfeng.hibernate.SalaryEntity;

/**
 * Created by lenovo on 2017/4/12.
 */
/*
* Salary-HousingFund-SocialSecurity-IncomeTax=SalaryActual
* */
public class SalaryActual {
    private int eid;
    private int name;
    private double gongziYingfa;
    private double gongziYingkou;
    private double gongziShifa;

    public SalaryActual() {
    }

    public SalaryActual(int eid, int name, double gongziYingfa, double gongziYingkou, double gongziShifa) {
        this.eid = eid;
        this.name = name;
        this.gongziYingfa = gongziYingfa;
        this.gongziYingkou = gongziYingkou;
        this.gongziShifa = gongziShifa;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public double getGongziYingfa() {
        return gongziYingfa;
    }

    public void setGongziYingfa(double gongziYingfa) {
        this.gongziYingfa = gongziYingfa;
    }

    public double getGongziYingkou() {
        return gongziYingkou;
    }

    public void setGongziYingkou(double gongziYingkou) {
        this.gongziYingkou = gongziYingkou;
    }

    public double getGongziShifa() {
        return gongziShifa;
    }

    public void setGongziShifa(double gongziShifa) {
        this.gongziShifa = gongziShifa;
    }
}
