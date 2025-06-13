package com.fransoufil.webflux_mini_demo.service;

import com.fransoufil.webflux_mini_demo.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUsuarioService {

    Mono<Usuario> buscarPorId(Long id);

    Flux<Usuario> listarComFlatMap();

    Flux<Usuario> listarComConcatMap();

    Flux<Usuario> buscarPorNome(String nome);

    Mono<Usuario> findByEmail(String email);

}
