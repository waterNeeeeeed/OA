package com.runfeng.spring.service;

/**
 * Created by lenovo on 2017/2/20.
 */
public class Chinese implements Person {
    private Axe axeType;

    public Axe getAxeType() {
        return axeType;
    }

    public void setAxeType(Axe axeType) {
        this.axeType = axeType;
    }

    public void useAxe(){
        System.out.println("Chinese plans to chop");
        System.out.println(axeType.chop());
    }
}
