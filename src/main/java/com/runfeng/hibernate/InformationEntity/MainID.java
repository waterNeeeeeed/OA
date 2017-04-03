package com.runfeng.hibernate.InformationEntity;

import org.hibernate.annotations.Parent;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by lenovo on 2017/4/3.
 */
@Embeddable
public class MainID
    implements Serializable{
    private int eid;
    private String name;
    @Parent
    private PersonalInfo personalInfo;

    public MainID() {
    }

    public MainID(int eid, String name) {
        this.eid = eid;
        this.name = name;
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == MainID.class){
            MainID mainID = (MainID)obj;
            return (mainID.eid == getEid());
        }

        return false;
    }
    public int hashCode(){
        return getEid();
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

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }
}
