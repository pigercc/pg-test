package com.pgtest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.session.data.redis.config.annotation.web.server.EnableRedisWebSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author pg
 * @date 2020/11/28
 */
@SpringBootApplication
@RestController
@Slf4j
@EnableRedisWebSession
public class WebFluxApplication {

    //支持老的mvc写法 也可以用 这种语法,但没有HttpRequestServlet，因为是netty容器
    @GetMapping("foo")
    public String foo()
    {
        return "foo";
    }

    //webflux eg1
    @GetMapping("hello")
    public Mono<String> hello()
    {
        return Mono.just("hello webflux");
    }
    //webflux eg2 greet2
    @GetMapping("greet2")
    public Mono<ResponseEntity> greet2(ServerHttpRequest serverRequest)
    {
        String body="greet2 "+serverRequest.getQueryParams().getFirst("name");
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(body));
    }

    //设置cookies
    @GetMapping("set-cookies")
    public String setCookies(ServerWebExchange serverWebExchange, String name, String value)
    {
        serverWebExchange.getResponse().addCookie(ResponseCookie.from(name,value).path("/").build());
        return "set suc";
    }

    //测试 write redis webSession
    @GetMapping("login")
    public Mono<String> login(ServerWebExchange serverWebExchange,String name)
    {
        return serverWebExchange.getSession().doOnNext(webSession -> {
            if(!webSession.isStarted())
            {
                webSession.start();
            }
            webSession.getAttributes().put("name",name);
        }).map(webSession -> webSession.save()).then(Mono.just("suc"));
    }
    //测试 query redis webSession
    @GetMapping("queryName")
    public Mono<String> queryNameFromSession(ServerWebExchange serverWebExchange,String name)
    {
        return serverWebExchange.getSession().map(webSession -> webSession.getAttribute("name"));
    }


    //func 写法，参考 GreetHandler和WebRouterConfiguration
    // localhost:port/greet?name=pg



    public static void main(String[] args) {
        SpringApplication.run(WebFluxApplication.class,args);
    }

}
