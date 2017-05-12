package com.runfeng.spring.service.SalaryService;

import com.runfeng.hibernate.SalaryEntity.SSBasicPercentPerMonth;

/**
 * Created by lenovo on 2017/5/12.
 */
public interface SalaryService {
    /*void salaryCheckAttendanceWash();
    void salarySocialSecurityWash();
    void salaryHousingFundWashWash();
    void salaryIncomeTaxWash();
    void salaryWash();*/

    //工资基数
    void querySalaryBasic();
    //应发工资项
    void querySalaryPlusItems();
    //实际工资
    void querySalaryActual();
    //奖金
    void queryBonus();

    //社保基数
    void querySSBasic();
    //社保基数每月比例
    void querySSBasicPercentPerMonth();
    //社保个人应缴
    void querySelfSocialSecurity();
    //社保公司应缴
    void queryComSocialSecurity();

    //公积金基数
    void queryHFBasic();
    //公积金每月比例
    void queryHFBasicPercent();
    //公积金个人应缴
    void querySelfHousingFund();
    //公积金公司应缴
    void queryComHousingFund();

    //个人所得税 本月工资+上月奖金-社保公积金-3500
    void queryIncomeTax();
}
