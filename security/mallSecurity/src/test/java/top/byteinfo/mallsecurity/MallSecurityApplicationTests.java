package top.byteinfo.mallsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.byteinfo.mallsecurity.dao.UmsAdminMapper;
import top.byteinfo.mallsecurity.entity.UmsAdmin;

import java.util.List;

@SpringBootTest
class MallSecurityApplicationTests {
    @Autowired
    UmsAdminMapper umsAdminMapper;

    @Test
    void contextLoads() {
        List<UmsAdmin> admin = umsAdminMapper.selectByPrimaryName("admin");
        System.out.println(admin);

    }

}
