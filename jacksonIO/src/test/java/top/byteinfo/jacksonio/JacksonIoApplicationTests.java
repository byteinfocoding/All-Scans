package top.byteinfo.jacksonio;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JacksonIoApplicationTests {


    @Test
    void contextLoads() {


    }

    /**
     * 简单数据绑定：比如绑定int类型、List、Map等…
     *
     * @throws JsonProcessingException
     */
    @Test
    void test1() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Integer age = objectMapper.readValue("1", int.class);
        Map map = objectMapper.readValue("{\"name\":\"yourname\"}", Map.class);
        System.out.println(age + "\n" + map);
    }

    /**
     * @throws JsonProcessingException
     */
    @Test
    void test2() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Developer developer = objectMapper.readValue("{\"name\": \"yourname\" , \"age\": 18,\"salary\":\"20K\"}", Developer.class);
        System.out.println(developer);
    }

    /**
     * objectMapper.writeValueAsString
     */
    @Test
    void test3() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(new HashMap<String, String>() {
                                                               {
                                                                   put("zhName", "A哥");
                                                                   put("enName", "YourBatman");
                                                               }
                                                           }
                )
        );


    }

    /**
     * objectMapper.readValue
     */
    void test4() {

    }


    @Test
    void test5() throws JsonProcessingException {
//        int a =1;
//        Integer inta = new Integer(11);
//       Long l= (Long)a;
//            Long ll = (Long)inta;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Long> list = objectMapper.readValue("[1.2,2.3,3,4,5]", List.class);
        System.out.println(list.get(0));
    }

    @Test
    void test51() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Data data = objectMapper.readValue("{\"ids\":[1,2,3,4,5]}", Data.class);
        test5();
        System.out.println(data.getIds().get(0));

        JsonMapper.builder()
                .configure(JsonReadFeature.ALLOW_SINGLE_QUOTES, true)
                .build().readValue("[1.2,2.3,3,4,5]", List.class);
    }
}