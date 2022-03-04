package com.example.alldateutils;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class AllDateUtilsApplicationTests {

    @Test
    void contextLoads() {
        Date date =new Date();
        System.out.println(date);

        Date datesetm = DateUtils.setSeconds(date, 20);
        Date dateaddm = DateUtils.addSeconds(date, 20);
        Date dateaddms = DateUtils.addSeconds(date, -20);
        System.out.println(datesetm);
        System.out.println(dateaddm);
        System.out.println(dateaddms);
        System.out.println("==========");
        System.out.println(date);
        System.out.println(date);
        System.out.println(datesetm);
        System.out.println(datesetm);
        System.out.println("==========");
        System.out.println(dateaddm);
        System.out.println(dateaddm);
        System.out.println("==========");
        System.out.println(dateaddms);
        System.out.println(dateaddms);



    }

}
