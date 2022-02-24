package top.byteinfo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.byteinfo.redis.configs.service.RedisService;

@SpringBootTest
class RedisApplicationTests {
//    @Autowired
//    RedisService redisService;

    @Autowired
    RedisService service;
    @Test
    void contextLoads() {
//        redisService.set("key11","1234567");
        service.set("key11","1234567");
    }

}
