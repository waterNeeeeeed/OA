package com.runfeng.hibernate;

import com.runfeng.hibernate.InformationEntity.PersonalInfo;

import java.util.List;

/**
 * Created by hasee-pc on 2017/4/9.
 */
public class PersonalInfoDAOImpl extends BaseDAOImpl<PersonalInfo>
    implements PersonalInfoDAO{
    /*BasicInfo*/
    @Override
    public List findAllBasicInfo() {
        /*"select p.mainID, p.basicInfo from PersonalInfo p"*/
        String hql = "select distinct pi.mainID, pi.basicInfo from PersonalInfo pi";
        return find(hql);
    }

    @Override
    public List findBasicInfoByDepartment(String department) {
        StringBuffer hql = new StringBuffer().append("select p.mainID, p.basicInfo from PersonalInfo p").append(" ");
        hql.append("where p.positionInfo.department = ?0");

        return find(hql.toString(), department);
    }

    @Override
    public List findAllPositionInfo() {
        return null;
    }

    @Override
    public List findAllEducationInfo() {
        return null;
    }

    @Override
    public List findAllContractInfo() {
        return null;
    }
}
