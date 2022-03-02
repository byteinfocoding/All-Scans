package top.byteinfo.aops.apo1;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Apo1ApplicationTests {

    @Test
    void contextLoads() throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        /**
         * //反射创建子类实例(对象)
         */
        val newInstance = Class.forName("").newInstance();
    }

}
