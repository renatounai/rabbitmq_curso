package com.rabbitmq.com.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqTesteApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqTesteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Eu rodei...");
		
		MensagemSimples mensagemSimples = new MensagemSimples();
		mensagemSimples.setName("MensagemSimples");
		mensagemSimples.setDescription("aqui está o texto da nossa primeira mensagem");
		
		rabbitTemplate.convertAndSend("PrimeiraExchange", "PrimeiraRouting", mensagemSimples);
		System.out.println("Terminei");
	}

}
