package com.runfeng.hibernate.InformationJson;
/**
 * Created by lenovo on 2017/4/3.
 */
public class ContractHead {
    private String eid;
    private String name;
    private String contractid;
    private String contractstartdate;
    private String contractenddate;
    private String contractstate;

    public ContractHead(String eid, String name, String contractid, String contractstartdate, String contractenddate, String contractstate) {
        this.eid = eid;
        this.name = name;
        this.contractid = contractid;
        this.contractstartdate = contractstartdate;
        this.contractenddate = contractenddate;
        this.contractstate = contractstate;
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

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getContractstartdate() {
        return contractstartdate;
    }

    public void setContractstartdate(String contractstartdate) {
        this.contractstartdate = contractstartdate;
    }

    public String getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(String contractenddate) {
        this.contractenddate = contractenddate;
    }

    public String getContractstate() {
        return contractstate;
    }

    public void setContractstate(String contractstate) {
        this.contractstate = contractstate;
    }
}
