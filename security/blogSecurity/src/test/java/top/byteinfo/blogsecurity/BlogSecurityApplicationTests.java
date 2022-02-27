package top.byteinfo.blogsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class BlogSecurityApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    void contextLoads() {
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);
    }

}
