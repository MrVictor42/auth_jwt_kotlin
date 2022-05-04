package com.example.SpringBootAuthJWT

import com.example.SpringBootAuthJWT.model.Client
import com.example.SpringBootAuthJWT.repository.ClientRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringBootAuthJwtApplication {
//	@Bean
//	fun run(clientRepository: ClientRepository) = CommandLineRunner {
//		val client = Client()
//
//		client.name = "Victor"
//		client.cpf = "00000000000"
//
//		clientRepository.save(client)
//	}
}
fun main(args: Array<String>) {
	runApplication<SpringBootAuthJwtApplication>(*args)
}