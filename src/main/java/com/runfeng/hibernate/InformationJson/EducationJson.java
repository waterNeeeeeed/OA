package com.runfeng.hibernate.InformationJson;

import com.runfeng.hibernate.InformationEntity.Education;
import com.runfeng.hibernate.InformationEntity.MainID;

/**
 * Created by lenovo on 2017/4/3.
 */
public class EducationJson {
    private int eid;
    private String name;
    private String educationalbackground;
    private String school;
    private String schoolform;
    private String major;

    public EducationJson(MainID mainID, Education education) {
        if (mainID != null){
            this.eid = mainID.getEid();
            this.name = mainID.getName();
        }
        if (education != null){
            this.educationalbackground = education.getEducationalbackground();
            this.school = education.getSchool();
            this.schoolform = education.getSchoolform();
            this.major = education.getMajor();
        }

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
