package top.byteinfo.mq.mallmq.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.byteinfo.mq.mallmq.mall.ampb.CancelOrderSender;
import top.byteinfo.mq.mallmq.mall.model.Result;

@RestController
@RequestMapping
public class HomeController {

    @Autowired
    CancelOrderSender cancelOrderSender;
    @GetMapping("/t11")
    Result<?> t1(){
        cancelOrderSender.sendMessage(11L,100);

        return Result.builder().message("send ok").build();
    }
}
