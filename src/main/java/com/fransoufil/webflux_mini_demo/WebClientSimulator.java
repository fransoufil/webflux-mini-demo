package com.fransoufil.webflux_mini_demo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientSimulator {

    private final WebClient client = WebClient.create();

    public Mono<String> obterInfoExterna() {
        return client.get()
                .uri("https://postman-echo.com/get")
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(e -> Mono.just("Fallback externo"));
    }
}
