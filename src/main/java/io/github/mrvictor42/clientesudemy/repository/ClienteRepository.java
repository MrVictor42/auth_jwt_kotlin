package io.github.mrvictor42.clientesudemy.repository;

import io.github.mrvictor42.clientesudemy.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
