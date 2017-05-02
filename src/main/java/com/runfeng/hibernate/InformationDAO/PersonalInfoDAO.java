package com.runfeng.hibernate.InformationDAO;

import com.runfeng.hibernate.BaseDAO;
import com.runfeng.hibernate.InformationEntity.*;
import com.runfeng.hibernate.InformationJson.BasicInfoJson;
import com.runfeng.hibernate.InformationJson.ContractJson;
import com.runfeng.hibernate.InformationJson.EducationJson;
import com.runfeng.hibernate.InformationJson.PositionInfoJson;

import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
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
    void updatePersonInfoBasicInfo(int eid, BasicInfoJson basicInfoJson);
    void updatePersonInfoPositionInfo(int eid, PositionInfoJson positionInfoJson);
    void updatePersonInfoEducationInfo(int eid, EducationJson educationInfoJson);
    void updatePersonInfoContractInfo(int eid, ContractJson contractInfoJson);
}
