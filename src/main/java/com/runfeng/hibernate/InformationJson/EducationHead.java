package com.runfeng.hibernate.InformationJson;

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

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducationalbackground() {
        return educationalbackground;
    }

    public void setEducationalbackground(String educationalbackground) {
        this.educationalbackground = educationalbackground;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolform() {
        return schoolform;
    }

    public void setSchoolform(String schoolform) {
        this.schoolform = schoolform;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
