package com.github.lostizalith.udemy.k8s.greeting;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class GreetingController {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(final GreetingHandler greetingHandler) {
        return route(POST("/greeting"), greetingHandler::greeting);
    }
}
