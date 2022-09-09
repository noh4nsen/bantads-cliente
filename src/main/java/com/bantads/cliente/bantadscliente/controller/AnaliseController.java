package com.bantads.cliente.bantadscliente.controller;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantads.cliente.bantadscliente.data.AnaliseRepository;
import com.bantads.cliente.bantadscliente.model.Analise;

@CrossOrigin
@RestController
@RequestMapping("analises")
public class AnaliseController {
    @Autowired
    private AnaliseRepository analiseRepository;

    @GetMapping("/por-gerente/{idexternogerente}")
    public ResponseEntity<List<Analise>> getAnalisesPendentes(@PathVariable UUID idexternogerente) {
        try {
            List<Analise> analises = analiseRepository.getAnalisesPendentes(idexternogerente);
            return ResponseEntity.ok(analises);
        } catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/health")
    public String health() {
        return "ʕ·͡ᴥ·ʔ";
    }    
}
