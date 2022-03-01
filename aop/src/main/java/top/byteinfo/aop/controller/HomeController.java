package top.byteinfo.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.byteinfo.aop.entity.OperationLog;
import top.byteinfo.aop.model.Result;

@RestController
public class HomeController {

    void t1test1(){
        System.out.println("t1test1");
        t1test2();
    }

    void t1test2(){
        System.out.println("t1test1");
    }
    String t1tes3(){
        String s="ss";
        System.out.println("t1test1");
        return new String("sss");
    }

    @RequestMapping(value = "/t1",method = RequestMethod.GET)
    public Result t1(){

        OperationLog operationLog = OperationLog.builder()
                .id(1)
                .ipAddress("192")
                .build();
        operationLog.setId(2);

        for (int i = 0; i < 10; i++) {
            int j= 1;
            System.out.println(i);
        }

        String s="123";

        return Result.builder()
                .data(s)
                .flag(true)
                .message("okok")
                .statusCode(200).build();
    }
}
