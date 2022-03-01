package top.byteinfo.aop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.byteinfo.aop.annotation.OptLog;
import top.byteinfo.aop.entity.OperationLog;
import top.byteinfo.aop.model.Result;

@RestController
@Api(tags = "@api")
public class HomeController {



    @RequestMapping(value = "/t1",method = RequestMethod.GET)
    public Result<?> t1(){

        OperationLog operationLog = OperationLog.builder()
                .id(1)
                .ipAddress("192")
                .build();
        operationLog.setId(2);


        return Result.builder()
                .data("123")
                .statusCode(200).build();
    }


    @GetMapping("aop1")
    @ApiOperation(value = "aop1@apiO")
    @OptLog(optType = "aop1@opt")
    public Result<?> aop1(){


        return Result.builder().data("aop1").statusCode(200).build();
    }

    @GetMapping("aop2")
    @ApiOperation(value = "aop2@apiO")
    public Result<?> aop2(){
        return Result.builder().data("aop2").statusCode(200).build();
    }

    @GetMapping("aop3")
    @ApiOperation(value = "aop3@apiO@opt")
    @OptLog(optType = "aop3@opt@apiO")
    public Result<?> aop3(){
        return Result.builder().data("aop3").statusCode(200).build();
    }


}
