package io.github.mrvictor42.clientesudemy.model.repository;

import io.github.mrvictor42.clientesudemy.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
