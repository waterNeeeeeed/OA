package com.runfeng.hibernate.InformationJson;

import com.runfeng.hibernate.InformationEntity.BasicInfo;
import com.runfeng.hibernate.InformationEntity.MainID;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class PersonalInfoJsonFactory {
    public BasicInfoJson createBasicInfoJson(MainID mainID, BasicInfo basicInfo){
        return new BasicInfoJson(mainID, basicInfo);
    }
    public List<BasicInfoJson> createBasicInfoJsonList(){
        return new ArrayList<BasicInfoJson>();
    }
}
