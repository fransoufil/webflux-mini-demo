package com.fransoufil.webflux_mini_demo.service.impl;

import com.fransoufil.webflux_mini_demo.model.Usuario;
import com.fransoufil.webflux_mini_demo.repository.UsuarioRepository;
import com.fransoufil.webflux_mini_demo.service.IUsuarioService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Mono<Usuario> findById(Long id) {
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

    @Override
    public Flux<Usuario> findByNome(String nome) {
        return repo.findByNomeContains(nome);
    }

    @Override
    public Mono<Usuario> findByEmail(String email) {
        return null;
    }

}

