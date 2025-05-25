package com.fransoufil.webflux_mini_demo.model;

import java.time.Instant;

public class LogAcesso {

    private String nomeUsuario;
    private Instant dataHora;

    public LogAcesso(String nomeUsuario, Instant dataHora) {
        this.nomeUsuario = nomeUsuario;
        this.dataHora = dataHora;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "LogAcesso{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }
}
