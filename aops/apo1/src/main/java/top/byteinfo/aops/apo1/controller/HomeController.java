package top.byteinfo.aops.apo1.controller;

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
}
