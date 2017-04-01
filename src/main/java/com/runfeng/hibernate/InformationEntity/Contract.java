package com.runfeng.hibernate.InformationEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private Date contractstartdate;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy.MM.dd")
    @Temporal(TemporalType.DATE)
    private Date contractenddate;
    private String contractstate;

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
