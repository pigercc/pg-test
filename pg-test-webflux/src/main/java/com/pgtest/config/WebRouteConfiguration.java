package com.pgtest.config;

import com.pgtest.handler.GreetHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author pg
 * @date 2020/11/28
 */
@Configuration
public class WebRouteConfiguration {

    @Bean
    public RouterFunction<ServerResponse> route(GreetHandler greetHandler)
    {
        return RouterFunctions.route(RequestPredicates.GET("/greet"),greetHandler::greet);
    }
}
