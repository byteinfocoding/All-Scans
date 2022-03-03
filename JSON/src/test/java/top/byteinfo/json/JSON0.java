package top.byteinfo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON0 {

    public static String toJSONString(Object o) throws JsonProcessingException {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }


    public static <T>T parseObject(String content, Class<T> clazz) throws JsonProcessingException {

        return new ObjectMapper().readValue(content,clazz);
    }


}
