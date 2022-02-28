package top.byteinfo.nblogsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import top.byteinfo.nblogsecurity.mapper.UserMapper;

@SpringBootTest
class NblogsecurityApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Test
    void contextLoads() {

//        User admin = userMapper.selectByPrimaryKey(1L);
//        System.out.println(admin);

        String encode = bCryptPasswordEncoder.encode("1234");
        System.out.println(encode);

    }

}
