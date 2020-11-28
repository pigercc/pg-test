package com.pgtest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebHandler;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

/**
 * @author pg
 * @date 2020/11/28
 */
@Configuration
public class WebConfiguration {

    @Bean
    WebSessionIdResolver webSessionIdResolver()
    {
        CookieWebSessionIdResolver webSessionIdResolver =new CookieWebSessionIdResolver();
        webSessionIdResolver.setCookieName("GATEWAY_B_SESSION");
        return webSessionIdResolver;
    }
}
