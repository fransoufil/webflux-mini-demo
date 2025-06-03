package com.fransoufil.webflux_mini_demo.service.impl;

import com.fransoufil.webflux_mini_demo.model.LogAcesso;
import com.fransoufil.webflux_mini_demo.model.Usuario;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Instant;

@Service
public class AuditoriaService {

    public Mono<LogAcesso> registrarAcesso(Usuario usuario) {
        return Mono.fromCallable(() -> {
            // Tarefa simulada bloqueante (ex: gravação em arquivo)
            Thread.sleep(100);
            return new LogAcesso(usuario.getNome(), Instant.now());
        }).subscribeOn(Schedulers.boundedElastic());
    }
}
