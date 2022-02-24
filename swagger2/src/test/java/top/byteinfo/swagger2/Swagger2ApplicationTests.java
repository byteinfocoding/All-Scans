package top.byteinfo.swagger2;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.fasterxml.jackson.core.json.JsonReadFeature.ALLOW_JAVA_COMMENTS;

@SpringBootTest
class Swagger2ApplicationTests {
    @Autowired

    @Test
    void contextLoads() {
//        SwaggerProperties.builder().
//        SwaggerProperties swaggerProperties= new SwaggerProperties()
//                .s

        System.out.println("");
        JsonMapper.builder().configure( ALLOW_JAVA_COMMENTS,true);
    }

}
