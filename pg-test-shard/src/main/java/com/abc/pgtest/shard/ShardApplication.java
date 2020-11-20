package com.abc.pgtest.shard;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pg
 * @date 2020/9/27
 */
@SpringBootApplication
@Slf4j
@RestController
@MapperScan("com.liying.pgtest.shard.dao*")
public class ShardApplication {

    @GetMapping("/foo")
    public String foo()
    {
        return "foo";
    }

    public static void main(String[] args) {
        SpringApplication.run(ShardApplication.class,args);
    }
}
