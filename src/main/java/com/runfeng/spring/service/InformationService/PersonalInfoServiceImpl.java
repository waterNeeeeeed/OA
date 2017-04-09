package com.runfeng.spring.service.InformationService;

import com.runfeng.hibernate.InformationEntity.BasicInfo;
import com.runfeng.hibernate.InformationEntity.MainID;
import com.runfeng.hibernate.InformationJson.BasicInfoJson;
import com.runfeng.hibernate.InformationJson.PersonalInfoJsonFactory;
import com.runfeng.hibernate.PersonalInfoDAO;
import com.runfeng.utils.JsonUtil;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class PersonalInfoServiceImpl implements PersonalInfoService {
    private PersonalInfoDAO personalInfoDAO;
    private PersonalInfoJsonFactory personalInfoJsonFactory;

    public PersonalInfoJsonFactory getPersonalInfoJsonFactory() {
        return personalInfoJsonFactory;
    }

    public void setPersonalInfoJsonFactory(PersonalInfoJsonFactory personalInfoJsonFactory) {
        this.personalInfoJsonFactory = personalInfoJsonFactory;
    }

    public PersonalInfoDAO getPersonalInfoDAO() {
        return personalInfoDAO;
    }

    public void setPersonalInfoDAO(PersonalInfoDAO personalInfoDAO) {
        this.personalInfoDAO = personalInfoDAO;
    }

    /********BasicInfo***************/
    private List<BasicInfoJson> createBIJ(List srcList, List objList){
        for (Iterator it=srcList.iterator(); it.hasNext(); ){
            Object[] objects = (Object[])it.next();
            MainID mainID = (MainID)objects[0];
            BasicInfo basicInfo = (BasicInfo)objects[1];
            objList.add(personalInfoJsonFactory.createBasicInfoJson(mainID, basicInfo));
        }
        return objList;
    }
    /*@Override*/
    public List<BasicInfoJson> findBasicInfoByDepartmentToJson(String department) {

        return null;
    }

    /*@Override*/
    public List<BasicInfoJson> findAllBasicInfoToJson() {
        List srcList = personalInfoDAO.findAllBasicInfo();
        List<BasicInfoJson> listBIJ = personalInfoJsonFactory.createBasicInfoJsonList();
        return createBIJ(srcList, listBIJ);
    }

    @Override
    public String findBasicInfo(String department) {
        if (department.equals("all")){
            return JsonUtil.toJson(findAllBasicInfoToJson());
        }else {
            return JsonUtil.toJson(findBasicInfoByDepartmentToJson(department));
        }
    }


}
