package com.snowalker.shardingjdbc.snowalker.demo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.snowalker.shardingjdbc.snowalker.demo.adapter.LocalDateTimeAdapter;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/28 5:44 下午
 * @description
 **/
public class GsonUtils {

    private static Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter());
        gson = gsonBuilder.create();
    }

    public static String obj2Json(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T json2obj(String obj, Class<T> type) {
        return gson.fromJson(obj, type);
    }


    /**
     * 字符串转换成集合，type事例：new TypeToken<List<AbcModel>>(){}.getType()
     *
     * @param obj     json格式字符串
     * @param typeOfT com.google.gson.reflect.TypeToken
     * @return
     */
    public static <T> T json2List(String obj, Type typeOfT) {
        return gson.fromJson(obj, typeOfT);
    }

}
