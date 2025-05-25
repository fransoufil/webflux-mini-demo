package com.fransoufil.webflux_mini_demo.service;

import com.fransoufil.webflux_mini_demo.model.Usuario;
import com.fransoufil.webflux_mini_demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Mono<Usuario> buscarPorId(Long id) {
        return repo.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Usuário não encontrado")));
    }

    public Flux<Usuario> listarComFlatMap() {
        return Flux.just("João", "Maria", "Ana")
                .flatMap(nome -> Mono.just(new Usuario(null, nome, nome + "@email.com"))
                        .delayElement(Duration.ofMillis(100))); // Simula tarefa concorrente
    }

    public Flux<Usuario> listarComConcatMap() {
        return Flux.just("João", "Maria", "Ana")
                .concatMap(nome -> Mono.just(new Usuario(null, nome, nome + "@email.com"))
                        .delayElement(Duration.ofMillis(100))); // Simula tarefa sequencial
    }
}

