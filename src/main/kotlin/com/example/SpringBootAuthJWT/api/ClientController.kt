package com.example.SpringBootAuthJWT.api

import com.example.SpringBootAuthJWT.model.Client
import com.example.SpringBootAuthJWT.repository.ClientRepository
import org.springframework.data.repository.query.Param
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.util.*

@RestController
@RequestMapping("/user")
class ClientController(val clientRepository: ClientRepository) {

    @PostMapping("/save")
    fun save(@RequestBody client: Client) : ResponseEntity<Client> {
        val uri : URI = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/save").toUriString())
        return ResponseEntity.created(uri).body(clientRepository.save(client))
    }

    @GetMapping("{id}")
    fun getClientById(@PathVariable id : Int) : Client {
        return clientRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id : Int) {
        return clientRepository.findById(id).map {
            clientRepository.deleteById(id)
        }.orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    }
}