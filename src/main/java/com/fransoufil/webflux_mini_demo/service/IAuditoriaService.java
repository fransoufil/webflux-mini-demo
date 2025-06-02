package com.fransoufil.webflux_mini_demo.service;

import com.fransoufil.webflux_mini_demo.model.LogAcesso;
import com.fransoufil.webflux_mini_demo.model.Usuario;
import reactor.core.publisher.Mono;

public interface IAuditoriaService {

    Mono<LogAcesso> registrarAcesso(Usuario usuario);

}
