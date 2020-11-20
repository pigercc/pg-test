package com.pg.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author pg
 * @date 2020/11/6
 */

//@ComponentScan({"com.abc","com.bcd"})
//@SpringBootApplication(scanBasePackages = {"com.abc","com.bcd","com.liying"})
@SpringBootApplication
@ComponentScan({"com.abc","com.bcd","com.liying"})
@RestController
public class WebApplication {

    @GetMapping("foo")
    public String foo()
    {
        return "foo";
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
