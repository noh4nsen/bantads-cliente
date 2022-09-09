package com.bantads.cliente.bantadscliente;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bantads.cliente.bantadscliente.services.Producer.Analise.SenderAnalise;
import com.bantads.cliente.bantadscliente.services.Producer.Rollback.SenderAutenticacao;
import com.fasterxml.jackson.databind.ObjectMapper;

@EnableRabbit
@SpringBootApplication
public class BantadsClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BantadsClienteApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public SenderAnalise senderA() {
		return new SenderAnalise();
	}

	@Bean
	public SenderAutenticacao senderAu() {
		return new SenderAutenticacao();
	}
}
