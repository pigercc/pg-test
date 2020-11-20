package com.abc.pgtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author pg
 * @date 2020/11/6
 */
@Configuration
@Slf4j
public class S3 {
    @PostConstruct
    private void init(){
        log.info("shutdown function enable");
    }
}
