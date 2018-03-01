package com.github.lostizalith.udemy.k8s.greeting;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

public interface RouterHandler {

    @NonNull
    Mono<ServerResponse> returnResponse(final ServerRequest request);

    @NonNull
    Mono<ServerResponse> greeting(final ServerRequest request);
}
