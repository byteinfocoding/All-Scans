package top.byteinfo.multiimpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MultiImplApplicationTests {

    @Autowired
    SearchStrategy searchStrategy;
    @Test
    void contextLoads() {

        List<String> stringList = searchStrategy.searchArticle("ssss");

        System.out.println(stringList);
    }

}
