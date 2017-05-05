package com.runfeng.utils.JEXL;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import java.util.Map;

/**
 * Created by lenovo on 2017/5/5.
 */
public class SalaryExpressionParseUtil {
    public static <T> T ExpressionParse(String expression, Map<String, T> args){
        JexlContext jexlContext = new MapContext();
        JexlEngine jexlEngine = new JexlEngine();
        Expression exprs = jexlEngine.createExpression(expression);

        args.forEach((k,v)->{
            jexlContext.set(k, v);
        });

        return (T)exprs.evaluate(jexlContext);
    }
}
