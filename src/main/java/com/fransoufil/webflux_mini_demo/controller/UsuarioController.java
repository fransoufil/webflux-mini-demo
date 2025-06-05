package com.fransoufil.webflux_mini_demo.controller;

import com.fransoufil.webflux_mini_demo.model.Usuario;
import com.fransoufil.webflux_mini_demo.service.impl.AuditoriaService;
import com.fransoufil.webflux_mini_demo.service.impl.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuditoriaService auditoriaService;

    public UsuarioController(UsuarioService usuarioService, AuditoriaService auditoriaService) {
        this.usuarioService = usuarioService;
        this.auditoriaService = auditoriaService;
    }

    @GetMapping("/{id}/acesso")
    public Mono<String> acessar(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .flatMap(auditoriaService::registrarAcesso)
                //.flatMap(usuario -> auditoriaService.registrarAcesso(usuario))
                .map(log -> "Acesso registrado em: " + log.getDataHora());
    }

    @GetMapping("/flat")
    public Flux<Usuario> listarComFlatMap() {
        return usuarioService.listarComFlatMap();
    }

    @GetMapping("/concat")
    public Flux<Usuario> listarComConcatMap() {
        return usuarioService.listarComConcatMap();
    }
}
