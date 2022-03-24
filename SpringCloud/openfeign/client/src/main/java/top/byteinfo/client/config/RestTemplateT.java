package top.byteinfo.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author codin
 * Created by codin on 2022/3/22
 */
@Configuration
public class RestTemplateT {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
