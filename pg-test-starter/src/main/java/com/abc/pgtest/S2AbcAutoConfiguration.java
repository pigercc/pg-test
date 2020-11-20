package com.abc.pgtest;

import com.bcd.pgtest.S2BcdAutoConfiguration;
import com.bcd.pgtest.S2Bean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author pg
 * @date 2020/11/6
 */
@Configuration
@Slf4j
@AutoConfigureAfter(S2BcdAutoConfiguration.class)
@ConditionalOnBean(S2Bean.class)
public class S2AbcAutoConfiguration {

    @Autowired
    S2Bean s2Bean;

    @PostConstruct
    private void init(){
        log.info("shutdown function enable {}",s2Bean.getName());
    }
}
