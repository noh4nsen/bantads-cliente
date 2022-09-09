package com.bantads.cliente.bantadscliente.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantads.cliente.bantadscliente.DTOs.AnalisePendenteDTO;
import com.bantads.cliente.bantadscliente.DTOs.AnaliseReprovacaoDTO;
import com.bantads.cliente.bantadscliente.data.AnaliseRepository;
import com.bantads.cliente.bantadscliente.mapper.AnaliseMapper;
import com.bantads.cliente.bantadscliente.model.Analise;

@CrossOrigin
@RestController
@RequestMapping("analises")
public class AnaliseController {
    @Autowired
    private AnaliseRepository analiseRepository;

    @GetMapping("/por-gerente/{idexternogerente}")
    public ResponseEntity<List<AnalisePendenteDTO>> getAnalisesPendentes(@PathVariable UUID idexternogerente) {
        try {
            List<Analise> analises = analiseRepository.getAnalisesPendentes(idexternogerente);
            List<AnalisePendenteDTO> response = AnaliseMapper.toResponseDTO(analises);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/aprovar/{id}")
    public ResponseEntity<String> aprovarAnalise(@PathVariable UUID id) {
        try {
            Optional<Analise> analiseOp = analiseRepository.findById(id);
            if(!analiseOp.isPresent())
                return ResponseEntity.notFound().build();

            Analise analise = analiseOp.get();
            analise.setAprovacao(true);
            analise.setDataHora(LocalDateTime.now());
            analiseRepository.save(analise);
            
            //TODO - enviar mensagem de saga de criacao de conta
            //TODO - enviar mensagem de saga para gerar senha e enviar por email

            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/reprovar/{id}")
    public ResponseEntity<String> reprovarAnalise(@PathVariable UUID id, @RequestBody AnaliseReprovacaoDTO analiseReprovacaoDTO){
        try {
            Optional<Analise> analiseOp = analiseRepository.findById(id);
            if(!analiseOp.isPresent())
                return ResponseEntity.notFound().build();

            Analise analise = analiseOp.get();
            analise.setAprovacao(false);
            analise.setMotivo(analiseReprovacaoDTO.getMotivo());
            analise.setDataHora(LocalDateTime.now());

            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/health")
    public String health() {
        return "ʕ·͡ᴥ·ʔ";
    }    
}
