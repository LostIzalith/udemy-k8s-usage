package com.github.lostizalith.udemy.k8s.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class GreetingController {

    private final RouterHandler routerHandler;

    @Autowired
    public GreetingController(final RouterHandler routerHandler) {
        this.routerHandler = routerHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction() {
        return route(POST("/greeting"), routerHandler::returnResponse)
                .andRoute(GET("/greeting"), routerHandler::greeting);
    }
}
