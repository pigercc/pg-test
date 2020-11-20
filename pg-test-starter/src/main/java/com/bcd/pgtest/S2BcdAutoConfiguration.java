package com.bcd.pgtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pg
 * @date 2020/11/6
 */
@Configuration
public class S2BcdAutoConfiguration {

    @Bean
    public S2Bean s2Bean()
    {
        S2Bean s2Bean = new S2Bean();
        s2Bean.setName("pg");
        return s2Bean;
    }
}
