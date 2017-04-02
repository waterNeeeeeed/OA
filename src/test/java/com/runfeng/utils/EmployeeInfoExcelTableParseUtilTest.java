package com.runfeng.utils;

import com.runfeng.hibernate.InformationEntity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import java.util.Map;

/**
 * Created by lenovo on 2017/3/31.
 */
public class EmployeeInfoExcelTableParseUtilTest {
    @Test
    public void inputEmployeeInfo() throws Exception {
        Configuration conf = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        Session sess = sf.openSession();
        Transaction tx = sess.beginTransaction();
        String hqlDelete = "delete PersonalInfo";
        sess.createQuery(hqlDelete).executeUpdate();
        Map<String, EmployeeInfo> employeeInfoMap = EmployeeInfoExcelTableParseUtil.inputEmployeeInfo(null);
        for (Map.Entry<String, EmployeeInfo> entry : employeeInfoMap.entrySet()){
            //System.out.println(JsonUtil.toJson(entry.getValue()));
            //
            BasicInfo basicInfo = new BasicInfo();
            Contract contract = new Contract(entry.getValue().getContractid(), entry.getValue().getContractstartdate(),
                                    entry.getValue().getContractenddate(), entry.getValue().getContractstate());
            Education education = new Education(entry.getValue().getEducationalbackground(), entry.getValue().getSchool(),
                                    entry.getValue().getSchoolform(), entry.getValue().getMajor());

            basicInfo.setName(entry.getValue().getName());
            basicInfo.setSex(entry.getValue().getSex());
            basicInfo.setIdentification(entry.getValue().getIdentification());
            basicInfo.setDepartment(entry.getValue().getDepartment());
            basicInfo.setPost(entry.getValue().getPost());
            basicInfo.setPosition(entry.getValue().getPosition());
            basicInfo.setPositionstate(entry.getValue().getPositionstate());


            PersonalInfo personalInfo = new PersonalInfo(entry.getValue().getEid(), basicInfo, contract, education);

            sess.save(personalInfo);
            System.out.println(JsonUtil.toJson(personalInfo));
        }
        tx.commit();
        sess.close();
        sf.close();

    }

    @Test
    public void inputEmployeeInfo2() throws Exception {
        System.out.println(JsonUtil.toJson(EmployeeInfoExcelTableParseUtil.inputEmployeeInfo(null).values()));
    }

    @Test
    public void outputEmployeeInfoToExcel() throws Exception {

    }

}