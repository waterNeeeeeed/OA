package com.runfeng.utils;

import com.runfeng.hibernate.HqlQuery;
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
            MainID mainID = new MainID(entry.getValue().getEid(), entry.getValue().getName());
            BasicInfo basicInfo = new BasicInfo(entry.getValue().getSex(),
                                    entry.getValue().getIdentification(), entry.getValue().getTelephone(), entry.getValue().getNativeplace());
            Contract contract = new Contract(entry.getValue().getContractid(), entry.getValue().getContractstartdate(),
                                    entry.getValue().getContractenddate(), entry.getValue().getContractstate());
            Education education = new Education(entry.getValue().getEducationalbackground(), entry.getValue().getSchool(),
                                    entry.getValue().getSchoolform(), entry.getValue().getMajor());

            PositionInfo positionInfo = new PositionInfo(entry.getValue().getWorkid(), entry.getValue().getDepartment(), entry.getValue().getPost(),
                                    entry.getValue().getPosition(), entry.getValue().getPositionstate());


            PersonalInfo personalInfo = new PersonalInfo(mainID, basicInfo, positionInfo, education, contract);

            sess.save(personalInfo);
        }
        tx.commit();
        sess.close();
        sf.close();

    }

    @Test
    public void inputEmployeeInfo2() throws Exception {
        //System.out.println(JsonUtil.toJson(EmployeeInfoExcelTableParseUtil.inputEmployeeInfo(null).values()));

        System.out.println(HqlQuery.findEmployeeInfo());
    }

    @Test
    public void outputEmployeeInfoToExcel() throws Exception {

    }

}