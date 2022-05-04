package com.example.SpringBootAuthJWT.api

import com.example.SpringBootAuthJWT.repository.ClientRepository
import org.springframework.web.bind.annotation.RestController

@RestController
class ClientController(val clientRepository: ClientRepository) {


}