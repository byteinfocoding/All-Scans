package top.byteinfo.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codin
 * Created by codin on 2022/3/22
 */
@RestController
public class HomeServerController {

    @GetMapping("/2")
   public String HelloServer(){
        System.out.println("HelloServer");
        return "HelloServer";
    }
}
