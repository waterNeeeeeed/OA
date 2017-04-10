package com.runfeng.hibernate.InformationJson;

import com.runfeng.hibernate.InformationEntity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class PersonalInfoJsonFactory {
    public<T> T create(MainID mainID, Object object, Class<T> Clz){
        if (Clz == BasicInfoJson.class){
            return (T)createBasicInfoJson(mainID, (BasicInfo)object);
        }
        if (Clz == PositionInfoJson.class){
            return (T)createPositionInfoJson(mainID, (PositionInfo)object);
        }
        if (Clz == EducationJson.class){
            return (T)createEducationJson(mainID, (Education)object);
        }
        if (Clz == ContractJson.class){
            return (T)createContractJson(mainID, (Contract)object);
        }
        return null;
    }

    public EmployeeInfo createEmployeeInfo(PersonalInfo personalInfo){
        return new EmployeeInfo(personalInfo.getMainID(), personalInfo.getBasicInfo(), personalInfo.getPositionInfo(),
                personalInfo.getContract(), personalInfo.getEducation());
    }
    public BasicInfoJson createBasicInfoJson(MainID mainID, BasicInfo basicInfo){
        return new BasicInfoJson(mainID, basicInfo);
    }

    public PositionInfoJson createPositionInfoJson(MainID mainID, PositionInfo positionInfo){
        return new PositionInfoJson(mainID, positionInfo);
    }

    public EducationJson createEducationJson(MainID mainID, Education education){
        return new EducationJson(mainID, education);
    }

    public ContractJson createContractJson(MainID mainID, Contract contract){
        return new ContractJson(mainID, contract);
    }

    public<T> List<T> createInfoJsonList(){
        return new ArrayList<T>();
    }
}
