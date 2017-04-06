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
    public static String convertTableHeadToJson(String resourcePath, String classPath){
        return JsonUtil.toJson(getTableHead(resourcePath, classPath));
    }

    public static Object getTableHead(String resourcePath, String classPath){
        Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
        ResourceBundle resourceBundle = ResourceBundle.getBundle(resourcePath, myLocale);

        try {
            Class clz = Class.forName(classPath);
            Object tableHead = clz.newInstance();

            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields){
                String method_name = "set" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
                clz.getMethod(method_name, String.class)
                        .invoke(tableHead, resourceBundle.getString(field.getName()));
            }
            return tableHead;
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
