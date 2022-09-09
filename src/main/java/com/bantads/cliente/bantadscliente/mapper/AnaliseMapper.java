package com.bantads.cliente.bantadscliente.mapper;

import java.time.LocalDateTime;
import java.util.UUID;

import com.bantads.cliente.bantadscliente.model.Analise;

public final class AnaliseMapper {
    public static Analise novaAnalise(UUID saga){
        Analise analise = new Analise();
        analise.setId(UUID.randomUUID());
        analise.setSaga(saga);
        analise.setDataHora(LocalDateTime.now());
        analise.setAprovacao(false);
        analise.setMotivo("");
        return analise;        
    }
}
