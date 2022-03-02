package top.byteinfo.cors.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController

public class HomeController {

    @RequestMapping("/cross")
    @ResponseBody
//使用@CrossOrigin开启跨域访问
//标注在处理器方法上方表示该方法支持跨域访问
//标注在处理器类上方表示该处理器类中的所有处理器方法均支持跨域访问
    @CrossOrigin
    public User cross(HttpServletRequest request) {
        System.out.println("controller cross..." + request.getRequestURL());
        User user = new User();
        user.setName("Jockme");
        user.setAge(39);
        return user;
    }

    class User {

        private String name;

        private Integer age;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



    }
}
