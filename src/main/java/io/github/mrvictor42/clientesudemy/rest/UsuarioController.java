package io.github.mrvictor42.clientesudemy.rest;

import io.github.mrvictor42.clientesudemy.model.entity.Usuario;
import io.github.mrvictor42.clientesudemy.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void salvar(@RequestBody @Valid Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
