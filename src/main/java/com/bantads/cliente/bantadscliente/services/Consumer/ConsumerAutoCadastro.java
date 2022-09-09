package com.bantads.cliente.bantadscliente.services.Consumer;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.cliente.bantadscliente.data.ClienteRepository;
import com.bantads.cliente.bantadscliente.model.Analise;
import com.bantads.cliente.bantadscliente.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ConsumerAutoCadastro {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @RabbitListener(queues = "autocadastro-cliente")
    public void receive(@Payload String json) {
        try {
            Cliente cliente = objectMapper.readValue(json, Cliente.class);
            cliente.setAnalise(novaAnalise(cliente.getSaga()));
            cliente.getEndereco().setId(UUID.randomUUID());
            clienteRepository.save(cliente);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private Analise novaAnalise(UUID saga){
        Analise analise = new Analise();
        analise.setId(UUID.randomUUID());
        analise.setSaga(saga);
        analise.setAprovacao(false);
        analise.setMotivo("");
        return analise;
    }
}
