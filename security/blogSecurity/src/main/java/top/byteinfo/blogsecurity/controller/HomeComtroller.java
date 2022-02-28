package top.byteinfo.blogsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeComtroller {
    @RequestMapping(value = "/admin/users",method = RequestMethod.GET)
    public void test1(){
        System.out.println("ok++++++++ok");
    }

}
