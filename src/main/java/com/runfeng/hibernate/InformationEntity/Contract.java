package com.runfeng.hibernate.InformationEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Parent;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by lenovo on 2017/4/1.
 */
@Embeddable
public class Contract {
    private String contractid;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    @Temporal(TemporalType.DATE)
    private Date contractfirstsigndate;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    @Temporal(TemporalType.DATE)
    private Date contractstartdate;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    @Temporal(TemporalType.DATE)
    private Date contractenddate;
    private String contractstate;
    @Parent
    private PersonalInfo personalInfo;

    public Contract() {
    }

    public Contract(String contractid, Date contractfirstsigndate, Date contractstartdate, Date contractenddate, String contractstate) {
        this.contractid = contractid;
        this.contractfirstsigndate = contractfirstsigndate;
        this.contractstartdate = contractstartdate;
        this.contractenddate = contractenddate;
        this.contractstate = contractstate;
    }

    public Date getContractfirstsigndate() {
        return contractfirstsigndate;
    }

    public void setContractfirstsigndate(Date contractfirstsigndate) {
        this.contractfirstsigndate = contractfirstsigndate;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public Date getContractstartdate() {
        return contractstartdate;
    }

    public void setContractstartdate(Date contractstartdate) {
        this.contractstartdate = contractstartdate;
    }

    public Date getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(Date contractenddate) {
        this.contractenddate = contractenddate;
    }

    public String getContractstate() {
        return contractstate;
    }

    public void setContractstate(String contractstate) {
        this.contractstate = contractstate;
    }
}
