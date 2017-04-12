package com.runfeng.utils.excel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2017/4/6.
 *
 office=经理办
 fd=财务部
 eed=设备工程部
 pwd=公用工程部
 pd=生产部
 qcd=质检部
 workshop=车间
 temp=临时用工
 all=总览

 */
public class outputExcelUtilTest {
    @Test
    public void outputExcelUtil() throws Exception {
        outputExcelUtil.outputExcelUtil("office", "basic");

        outputExcelUtil.outputExcelUtil("fd", "basic");
        outputExcelUtil.outputExcelUtil("eed", "basic");
        outputExcelUtil.outputExcelUtil("pwd", "basic");
        outputExcelUtil.outputExcelUtil("pd", "basic");
        outputExcelUtil.outputExcelUtil("qcd", "basic");
        outputExcelUtil.outputExcelUtil("workshop", "basic");
    }

}