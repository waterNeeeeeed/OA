package com.runfeng.hibernate.InformationEntity;

/**
 * Created by lenovo on 2017/4/3.
 */
public class EducationHead {
    private String eid;
    private String name;
    private String educationalbackground;
    private String school;
    private String schoolform;
    private String major;

    public EducationHead(String eid, String name, String educationalbackground, String school, String schoolform, String major) {
        this.eid = eid;
        this.name = name;
        this.educationalbackground = educationalbackground;
        this.school = school;
        this.schoolform = schoolform;
        this.major = major;
    }
}
