package com.example.SpringBootAuthJWT.repository

import com.example.SpringBootAuthJWT.model.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository : JpaRepository<Client, Int> {

}