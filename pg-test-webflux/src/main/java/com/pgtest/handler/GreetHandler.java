package com.pgtest.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author pg
 * @date 2020/11/28
 */
@Component
public class GreetHandler {

    public Mono<ServerResponse> greet(ServerRequest serverRequest)
    {
        String name=serverRequest.queryParam("name").get();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject("greet "+name));
    }
}
