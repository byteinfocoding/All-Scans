package top.byteinfo.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class JsonApplicationTests {
    @Data
    @AllArgsConstructor
   public static class User {
        private String name;
        private Integer age;
    }

    @AllArgsConstructor
    @Data
   public static class Admin {

        private String username;
        private Integer age;
    }

    @Test
    void contextLoads() throws JsonProcessingException {

        Object userJson = JSON.toJSON(new User("z", 10));

        String toJSONString = JSON.toJSONString(new User("z", 10));

        User user = JSON.parseObject(toJSONString, User.class);

        String z = JSON0.toJSONString(new Admin("z", 11));
//        Admin admin = JSON0.parseObject(z, Admin.class);
//        System.out.println("");

    }

}
