package com.runfeng.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by 帝 on 2017/3/28.
 */
public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String toJson(T obj){
        String Json;
        try {
            Json = OBJECT_MAPPER.writeValueAsString(obj);

        } catch (JsonProcessingException e) {
            LOGGER.error("类转换JSON错误", e);
            throw new RuntimeException(e);
        }
        return Json;
    }

    public static <T> T fromJson(String json, Class<T> type){
        T pojo;
        try{
            pojo = OBJECT_MAPPER.readValue(json, type);

        }catch (Exception e){
            LOGGER.error("JSON转换类错误", e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
