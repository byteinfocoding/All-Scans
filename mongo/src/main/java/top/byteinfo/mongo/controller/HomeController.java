package top.byteinfo.mongo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.byteinfo.mongo.log.LogEntity;
import top.byteinfo.mongo.model.JSON;
import top.byteinfo.mongo.model.Result;
import top.byteinfo.mongo.mongo.LogDAO;
import top.byteinfo.mongo.mongo.LogRepository;

import java.util.List;

@RestController
@RequestMapping
public class HomeController {
    @Autowired
    private LogDAO logDAO;

    @Autowired
    LogRepository logRepository;
    @GetMapping("/t1")
    Result<?> t1() throws JsonProcessingException {
        logDAO.insert(LogEntity.builder().message("mongo ok").build());
        logRepository.insert(LogEntity.builder().requestUrl("/t1").message("mongo ok").build());
        List<LogEntity> logEntityList = logRepository.findAll();

        return Result.builder().data(JSON.toJSONString(logEntityList)).statusCode(200).message("ok").build();
    }
}
