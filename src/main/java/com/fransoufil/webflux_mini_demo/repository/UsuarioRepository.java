package com.fransoufil.webflux_mini_demo.repository;

import com.fransoufil.webflux_mini_demo.model.Usuario;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UsuarioRepository extends ReactiveCrudRepository<Usuario, Long> {

    Flux<Usuario> findByNomeContains(String nome);
}
