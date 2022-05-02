package com.example.SpringBootAuthJWT

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Hello {

    @Value("\${application.name}")
    val applicationName : String = ""

    @GetMapping("/hello")
    fun hello() : String {
        return applicationName
    }
}