package com.bantads.cliente.bantadscliente;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

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
}
