package com.bantads.cliente.bantadscliente.data;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bantads.cliente.bantadscliente.model.Analise;

public interface AnaliseRepository extends JpaRepository<Analise, UUID> {
    
}
