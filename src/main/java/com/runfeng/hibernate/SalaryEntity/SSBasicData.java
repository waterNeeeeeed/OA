package com.runfeng.hibernate.SalaryEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.runfeng.hibernate.InformationEntity.MainID;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by lenovo on 2017/4/10.
 */

public class SSBasicData {
    private MainID mainID;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy")
    @Temporal(TemporalType.DATE)
    private Date ssYear;
    private double ssBasicData;
}
