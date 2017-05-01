package com.runfeng.hibernate.InformationDAO;

import com.runfeng.hibernate.BaseDAO;
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
public interface PersonalInfoDAO extends BaseDAO<PersonalInfo> {
    List findAllBasicInfo();//
    List findBasicInfoByDepartment(String department);

    List findAllPositionInfo();
    List findPositionInfoByDepartment(String department);

    List findAllEducationInfo();
    List findEducationInfoByDepartment(String department);

    List findAllContractInfo();
    List findContractInfoByDepartment(String department);

    List findAllEmployeeInfo();
    List findEmployeeInfoByDepartment(String department);

    List findAllContractstate();
    long findContractstateCount(String Contractstate);

    PersonalInfo findPersonalInfo(int eid);
    void updatePersonInfoBasicInfo(int eid, BasicInfo basicInfo);
}
