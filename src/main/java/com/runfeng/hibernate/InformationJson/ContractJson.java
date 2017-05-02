package com.runfeng.hibernate.InformationJson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.runfeng.hibernate.InformationEntity.Contract;
import com.runfeng.hibernate.InformationEntity.MainID;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by lenovo on 2017/4/3.
 */
public class ContractJson{
    private int eid;
    private String name;
    private String contractid;
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    @Temporal(TemporalType.DATE)
    private Date contractfirstsigndate;
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    @Temporal(TemporalType.DATE)
    private Date contractstartdate;
    //@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    @Temporal(TemporalType.DATE)
    private Date contractenddate;
    private String contractstate;

    public ContractJson() {
    }

    public ContractJson(MainID mainID, Contract contract) {
        if (mainID != null){
            this.eid = mainID.getEid();
            this.name = mainID.getName();
        }
        if (contract != null){
            this.contractid = contract.getContractid();
            this.contractfirstsigndate = contract.getContractfirstsigndate();
            this.contractstartdate = contract.getContractstartdate();
            this.contractenddate = contract.getContractenddate();
            this.contractstate = contract.getContractstate();
        }

    }

    public Date getContractfirstsigndate() {
        return contractfirstsigndate;
    }

    public void setContractfirstsigndate(Date contractfirstsigndate) {
        this.contractfirstsigndate = contractfirstsigndate;
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
