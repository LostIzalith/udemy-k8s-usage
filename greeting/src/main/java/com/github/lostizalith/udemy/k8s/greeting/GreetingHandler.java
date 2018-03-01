package com.github.lostizalith.udemy.k8s.greeting;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import java.util.Optional;

@Component
public class GreetingHandler implements RouterHandler {

    @Override
    @NonNull
    public Mono<ServerResponse> returnResponse(final ServerRequest request) {
        return ServerResponse.ok().body(request.bodyToMono(String.class), String.class)
                .switchIfEmpty(ServerResponse.noContent().build());
    }

    @Override
    @NonNull
    public Mono<ServerResponse> greeting(final ServerRequest request) {
        final Optional<String> name = request.queryParam("name");

        return ServerResponse.ok().body(Mono.justOrEmpty(name), String.class);
    }
}
