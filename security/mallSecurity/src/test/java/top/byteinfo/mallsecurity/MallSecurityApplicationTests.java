package top.byteinfo.mallsecurity;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.byteinfo.mallsecurity.dao.UmsAdminMapper;
import top.byteinfo.mallsecurity.dao.UmsResourceMapper;
import top.byteinfo.mallsecurity.utils.JSON;

@SpringBootTest
class MallSecurityApplicationTests {
    @Autowired
    UmsAdminMapper umsAdminMapper;
    @Autowired
    UmsResourceMapper umsResourceMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
//        List<UmsAdmin> admin = umsAdminMapper.selectByPrimaryName("admin");
//        System.out.println(admin);

        String toJSONString = JSON.toJSONString(umsResourceMapper.selectAll());
        System.out.println(toJSONString);
    }

}
