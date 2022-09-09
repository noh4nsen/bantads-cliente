package com.bantads.cliente.bantadscliente.services.Producer;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderAnalise {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue queueAnaliseGerente;

    public void send(UUID saga){
        this.template.convertAndSend(this.queueAnaliseGerente.getName(), saga);
    }
}
