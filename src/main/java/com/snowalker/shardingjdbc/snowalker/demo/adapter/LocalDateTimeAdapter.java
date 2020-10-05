package com.snowalker.shardingjdbc.snowalker.demo.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.snowalker.shardingjdbc.snowalker.demo.utils.LocalDateUtils;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author taowei
 * @version 1.0.0
 * @date 2020/9/28 5:49 下午
 * @description
 **/
public class LocalDateTimeAdapter  extends TypeAdapter<LocalDateTime> {

    public void write(JsonWriter writer, LocalDateTime value) throws IOException {
        if (value == null) {
            writer.nullValue();
            return;
        }

        writer.value(LocalDateUtils.getLongFromLocalDateTime(value));
    }

    public LocalDateTime read(JsonReader reader) throws IOException {
        if (reader.peek() == JsonToken.NULL) {
            reader.nextNull();
            return null;
        }
        Long dateTime = reader.nextLong();
        return LocalDateUtils.getLocalDateTimeFromLong(dateTime);
    }

}
