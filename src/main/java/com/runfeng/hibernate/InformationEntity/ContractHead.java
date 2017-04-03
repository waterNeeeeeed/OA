package com.runfeng.hibernate.InformationEntity;
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
}
