package io.github.mrvictor42.clientesudemy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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