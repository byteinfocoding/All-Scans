package top.byteinfo.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MqApplication {

    //https://www.rabbitmq.com/getstarted.html
    public static void main(String[] args) {
        SpringApplication.run(MqApplication.class, args);
    }

}
