package com.runfeng.utils;

import com.runfeng.hibernate.InformationEntity.EmployeesInfoHead;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by lenovo on 2017/4/4.
 */
public class TableHeadParseUtil {


    public static String convertEmployeesInfoHeadToJson(){
        Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
        ResourceBundle resourceBundle = ResourceBundle.getBundle("tablehead/employeesinfo_tablehead", myLocale);

        try {
            Class clz = Class.forName("com.runfeng.hibernate.InformationEntity.EmployeesInfoHead");

            Field[] fields = EmployeesInfoHead.class.getDeclaredFields();
            for (Field field : fields){
                String method_name = "set" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
                clz.getMethod(method_name, String.class)
                        .invoke(clz.newInstance(), resourceBundle.getString(field.getName()));
            }
            return JsonUtil.toJson(clz.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;

    }
}
