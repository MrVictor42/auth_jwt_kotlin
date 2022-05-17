package io.github.mrvictor42.clientesudemy;

import io.github.mrvictor42.clientesudemy.model.entity.Cliente;
import io.github.mrvictor42.clientesudemy.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesUdemyApplication {

//	@Bean
//	public CommandLineRunner run(@Autowired ClienteRepository clienteRepository) {
//		return args -> {
//			Cliente cliente = new Cliente();
//
//			cliente.setCpf("00000000000");
//			cliente.setNome("Victor");
//			clienteRepository.save(cliente);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(ClientesUdemyApplication.class, args);
	}
}