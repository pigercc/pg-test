package com.pgtest;

import com.liying.common.util.LoginUserUtil;
import com.pgtest.model.TimeQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Random;

/**
 * @author pg
 * @date 2020/11/9
 */
@SpringBootApplication(scanBasePackages = {"com.liying","com.jq"})
@RestController
@RequestMapping("test/mangoAuth")
@Slf4j
public class SpringSessionApplication {

    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null)
            return null;

        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }



    @PostMapping("testTimeLimit")
    public String testTimeLimit(@RequestBody TimeQuery timeQuery)
    {
        return "timeQuery :"+timeQuery;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class,args);
    }
}
