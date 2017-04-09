package com.runfeng.hibernate;

import com.runfeng.hibernate.InformationEntity.BasicInfo;
import com.runfeng.hibernate.InformationEntity.MainID;
import com.runfeng.hibernate.InformationEntity.PersonalInfo;

import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
/*
    private MainID mainID;
    private BasicInfo basicInfo;
    private PositionInfo positionInfo;
    private Education education;
    private Contract contract;
 */
public interface PersonalInfoDAO extends BaseDAO<PersonalInfo>{
    List findAllBasicInfo();//
    List findBasicInfoByDepartment(String Department);

    List findAllPositionInfo();
    List findAllEducationInfo();
    List findAllContractInfo();
}
