package io.github.mrvictor42.clientesudemy.rest;

import io.github.mrvictor42.clientesudemy.exception.UsuarioCadastradoException;
import io.github.mrvictor42.clientesudemy.model.entity.Usuario;
import io.github.mrvictor42.clientesudemy.model.repository.UsuarioRepository;
import io.github.mrvictor42.clientesudemy.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void salvar(@RequestBody @Valid Usuario usuario) {
        try {
            usuarioService.salvar(usuario);
        } catch (UsuarioCadastradoException error) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.getMessage());
        }
    }
}
