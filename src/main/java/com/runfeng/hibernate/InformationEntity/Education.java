package com.runfeng.hibernate.InformationEntity;

import javax.persistence.Embeddable;

/**
 * Created by lenovo on 2017/4/1.
 */
@Embeddable
public class Education {
    private String educationalbackground;
    private String school;
    private String schoolform;
    private String major;

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
