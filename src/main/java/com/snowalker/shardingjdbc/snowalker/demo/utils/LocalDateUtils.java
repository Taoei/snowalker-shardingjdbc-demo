package com.snowalker.shardingjdbc.snowalker.demo.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/28 5:50 下午
 * @description
 **/
public class LocalDateUtils {

    private static final ZoneId ZONE_ID = ZoneId.systemDefault();
    public static LocalDateTime getLocalDateTimeFromLong(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZONE_ID);
    }

    public static Long getLongFromLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZONE_ID).toInstant().toEpochMilli();
    }

    public static LocalDate getLocalDateFromLong(long timestamp) {
        return Instant.ofEpochMilli(timestamp).atZone(ZONE_ID).toLocalDate();
    }
    public static Long getLongFromLocalDate(LocalDate localDate) {
        return localDate.atStartOfDay(ZONE_ID).toInstant().toEpochMilli();
    }

}
