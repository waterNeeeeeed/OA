package com.runfeng.spring.test;

/**
 * Created by hasee-pc on 2017/2/21.
 */
public class Chinese implements Person{
    private Axe axeType;

    Chinese(Axe axeType){
        this.axeType = axeType;
    }
    public void useAxe() {
        System.out.println("Chinese use " + axeType.chop() + ":constructor");
    }
}
