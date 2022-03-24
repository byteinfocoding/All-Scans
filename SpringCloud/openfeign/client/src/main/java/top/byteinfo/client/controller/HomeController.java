package top.byteinfo.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.simple.SimpleDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author codin
 * Created by codin on 2022/3/22
 */
@RestController
public class HomeController {
    SimpleDiscoveryClient simpleDiscoveryClient;

    @Autowired
    RestTemplate restTemplate;



    @GetMapping("/1")
    public String Hello(){
        System.out.println("Hello");
        return "Hello";
    }

    @GetMapping("/2")
    public String Hello1(){
        System.out.println("start");
        String forObject = restTemplate.getForObject("http://127.0.0.1:8011/2", String.class);

        System.out.println("Hello");
        return forObject;
    }



}
