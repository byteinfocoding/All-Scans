package top.byteinfo.springsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSessionApplication {

    //Session 统一存储到一个共享区域，支持多种存储形式。https://spring.io/projects/spring-session
    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class, args);
    }

}
