package com.bantads.cliente.bantadscliente.services.Consumer;

import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bantads.cliente.bantadscliente.data.ClienteRepository;

@Component
public class ConsumerRollback {
    @Autowired
    private ClienteRepository clienteRepository;

    @RabbitListener(queues = "rollback-autocadastro-cliente")
    public void receive(@Payload String json) {
        try {
            UUID saga = UUID.fromString(json);
            clienteRepository.deleteBySaga(saga);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
