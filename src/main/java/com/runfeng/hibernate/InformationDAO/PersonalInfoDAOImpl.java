package com.runfeng.hibernate.InformationDAO;

import com.runfeng.hibernate.BaseDAOImpl;
import com.runfeng.hibernate.InformationEntity.BasicInfo;
import com.runfeng.hibernate.InformationEntity.PersonalInfo;
import com.runfeng.hibernate.InformationJson.BasicInfoJson;

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
        String hql = "select distinct pi.mainID, pi.positionInfo from PersonalInfo pi";
        return find(hql);
    }

    @Override
    public List findPositionInfoByDepartment(String department) {
        StringBuffer hql = new StringBuffer().append("select distinct pi.mainID, pi.positionInfo from PersonalInfo pi")
                .append(" ").append("where pi.positionInfo.department = ?0");
        return find(hql.toString(), department);
    }

    @Override
    public List findAllEducationInfo() {
        String hql = "select distinct pi.mainID, pi.education from PersonalInfo pi";
        return find(hql);
    }

    @Override
    public List findEducationInfoByDepartment(String department) {
        StringBuffer hql = new StringBuffer().append("select distinct pi.mainID, pi.education from PersonalInfo pi")
                .append(" ").append("where pi.positionInfo.department = ?0");
        return find(hql.toString(), department);
    }

    @Override
    public List findAllContractInfo() {
        String hql = "select distinct pi.mainID, pi.contract from PersonalInfo pi";
        return find(hql);
    }

    @Override
    public List findContractInfoByDepartment(String department) {
        StringBuffer hql = new StringBuffer().append("select distinct pi.mainID, pi.contract from PersonalInfo pi")
                .append(" ").append("where pi.positionInfo.department = ?0");
        return find(hql.toString(), department);
    }

    @Override
    public List findAllEmployeeInfo() {
        String hql = "select distinct pi from PersonalInfo pi";
        return find(hql);
    }

    @Override
    public List findEmployeeInfoByDepartment(String department) {
        StringBuffer hql = new StringBuffer().append("select pi from PersonalInfo pi")
                .append(" ").append("where pi.positionInfo.department = ?0");
        return find(hql.toString(), department);
    }

    @Override
    public List findAllContractstate() {
        String hql = "select distinct pi.contract.contractstate from PersonalInfo pi";
        //未完
        return find(hql);
    }

    @Override
    public long findContractstateCount(String Contractstate) {
        StringBuffer hql = new StringBuffer()
                .append("select count(*) pi.contract.contractstate from PersonalInfo pi")
                .append(" ")
                .append("where pi.contract.contractstate = ?0");
        List list = find(hql.toString(), Contractstate);

        return (long)list.get(0);
    }

    @Override
    public PersonalInfo findPersonalInfo(int eid) {
        StringBuffer hql = new StringBuffer()
                .append("select pi from PersonalInfo pi")
                .append("where pi.mainID.eid = ?0");
        List list = find(hql.toString(), eid);
        return (PersonalInfo)list.get(0);
    }

    @Override
    public void updatePersonInfoBasicInfo(int eid, BasicInfoJson basicInfoJson) {
        StringBuffer hql = new StringBuffer()
                .append("update PersonalInfo pi ")
                .append("set pi.basicInfo.sex = ?0,")
                .append("pi.basicInfo.identification = ?1,")
                .append("pi.basicInfo.telephone = ?2,")
                .append("pi.basicInfo.nativeplace = ?3 ")
                .append("where pi.mainID.eid = ?4");
        update(hql.toString(),
                basicInfoJson.getSex(),
                basicInfoJson.getIdentification(),
                basicInfoJson.getTelephone(),
                basicInfoJson.getNativeplace(),
                eid);
    }

    @Override
    public void updatePersonInfo(int eid, Object object) {

    }
}
