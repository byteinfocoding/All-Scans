package top.byteinfo.aops.aop0.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.byteinfo.aops.aop0.model.Result;

@RestController
@RequestMapping
public class HomeController {

    @GetMapping("aop1")
    public Result<?> aop1(){
        return Result.builder().data("aop1").statusCode(200).build();
    }
    @GetMapping("aop2")
    public Result<?> aop2(){
        return Result.builder().data("aop2").statusCode(200).build();
    }
    @GetMapping("aop3")
    public Result<?> aop3(){
        return Result.builder().data("aop3").statusCode(200).build();
    }
    @GetMapping("aop4")
    public Result<?> aop4(){
        return Result.builder().data("aop4").statusCode(200).build();
    }
}
