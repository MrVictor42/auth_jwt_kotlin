package com.example.SpringBootAuthJWT.repository

import com.example.SpringBootAuthJWT.model.Service
import org.springframework.data.jpa.repository.JpaRepository

interface ServiceRepository : JpaRepository<Service, Int> {

}