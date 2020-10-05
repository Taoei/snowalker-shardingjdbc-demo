package com.snowalker.shardingjdbc.snowalker.demo.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.*;

/**
 * @author xuechai
 * @date 2019/8/27
 */
@Slf4j
public class BeanTransferUtil {
    /**
     * 直接拷贝
     */
    public static <T, S> List<T> convertList(List<S> src, Class<T> targetClass) {
        if (src == null) {
            return Collections.EMPTY_LIST;
        }
        List<T> target = new ArrayList<>(src.size());
        for (S s : src) {
            T t = BeanUtils.instantiateClass(targetClass);
            BeanUtils.copyProperties(s, t);
            target.add(t);
        }
        return target;
    }

    /**
     * 序列化再反序列化的方式进行拷贝
     */
    public static <T, S> List<T> copyList(List<S> list, Class<T> targetClass) {
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        List<T> result = new ArrayList<>(list.size());
        for (S bean : list) {
            result.add(copyBean(bean, targetClass));
        }
        return result;
    }

    /**
     * 直接拷贝
     */
    public static <T, S> T convertBean(S bean, Class<T> targetClass) {
        T target = BeanUtils.instantiateClass(targetClass);
        BeanUtils.copyProperties(bean, target);
        return target;
    }

    /**
     * 序列化再反序列化的方式进行拷贝
     *
     * @return
     */
    public static <T, S> T copyBean(S bean, Class<T> targetClass) {
        String sourceStr = GsonUtils.obj2Json(bean);
        T target = null;
        try {
            target = GsonUtils.json2obj(sourceStr, targetClass);
        } catch (Exception e) {
            log.error("[GSON 数据解析异常] target={}", targetClass, e);
        }
        return target;
    }

    /**
     * 忽略NULL值
     */
    public static void copyPropertiesIgnoreNull(Object src, Object target){
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
