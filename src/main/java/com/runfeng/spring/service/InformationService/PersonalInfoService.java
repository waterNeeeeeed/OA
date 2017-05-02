package com.runfeng.spring.service.InformationService;

import com.runfeng.hibernate.InformationEntity.BasicInfo;
import com.runfeng.hibernate.InformationEntity.MainID;
import com.runfeng.hibernate.InformationJson.BasicInfoJson;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public interface PersonalInfoService {
    /*BasicInfo*/
    /*List<BasicInfoJson> findAllBasicInfoToJson();
    List<BasicInfoJson> findBasicInfoByDepartmentToJson(String department);*/
    String findBasicInfo(String department);
    String findPositionInfo(String department);
    String findEmployeeInfo(String department);
    String findEducationInfo(String department);
    String findContractInfo(String department);
    String findPersonInfo(String department, String infoType);
    String findPersonInfoTableHead(String department, String infoType);
    String findNumberOfEmployees();
    //void updatePersonalInfo(int eid, BasicInfoJson basicInfoJson);
    void updatePersonalInfo(String modifyType, int eid, String entityJson);
}
