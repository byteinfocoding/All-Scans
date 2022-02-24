package top.byteinfo.swagger2;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_JAVA_COMMENTS;

@SpringBootTest
class Swagger2ApplicationTests {

    @Test
    void contextLoads() {
//        SwaggerProperties.builder().
        System.out.println("");
        JsonMapper.builder().configure( ALLOW_JAVA_COMMENTS,true);
    }

}
