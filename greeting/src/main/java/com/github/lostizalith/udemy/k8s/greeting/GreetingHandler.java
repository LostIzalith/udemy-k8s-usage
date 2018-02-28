package com.github.lostizalith.udemy.k8s.greeting;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> greeting(final ServerRequest request) {
        return ServerResponse.ok().body(request.bodyToMono(String.class), String.class);
    }
}
