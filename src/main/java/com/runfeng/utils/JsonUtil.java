package com.runfeng.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by 帝 on 2017/3/28.
 */
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> String toJson(T obj){
        String Json;
        try {
            Json = OBJECT_MAPPER.writeValueAsString(obj);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return Json;
    }
}
