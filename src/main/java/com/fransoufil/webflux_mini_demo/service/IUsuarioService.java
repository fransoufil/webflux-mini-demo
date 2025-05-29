package com.fransoufil.webflux_mini_demo.service;

import com.fransoufil.webflux_mini_demo.model.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUsuarioService {

    public Mono<Usuario> buscarPorId(Long id);

    public Flux<Usuario> listarComFlatMap();

    public Flux<Usuario> listarComConcatMap();

}
