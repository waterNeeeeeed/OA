package com.runfeng.utils.JEXL;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;
import org.junit.Test;


import java.text.DecimalFormat;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2017/5/5.
 */
public class SalaryExpressionParseUtilTest {
    @Test
    public void ExpressionParse() throws Exception {
        String exprs = "(a*b)/5+100";
        HashMap<String, Double> args = new HashMap<>();
        Double temp;
        args.put("a", Double.parseDouble("100"));
        args.put("b", Double.parseDouble("20"));
        double test = SalaryExpressionParseUtil.ExpressionParse(exprs, args);

        System.out.println(test);

    }

    void test(){

    }

}