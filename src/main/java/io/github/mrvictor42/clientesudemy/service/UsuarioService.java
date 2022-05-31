package io.github.mrvictor42.clientesudemy.service;

import io.github.mrvictor42.clientesudemy.exception.UsuarioCadastradoException;
import io.github.mrvictor42.clientesudemy.model.entity.Usuario;
import io.github.mrvictor42.clientesudemy.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        boolean exists = usuarioRepository.existsByUsername(usuario.getUsername());

        if(exists) {
            throw new UsuarioCadastradoException(usuario.getPassword());
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario =
                usuarioRepository
                        .findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado!"));
        // EM ROLES, SE USA AS ROLES DO USUÁRIO, NESSE CASO SÓ É USER POR QUE NÃO TEM OUTRA CRIADA
        return User.builder().username(usuario.getUsername()).password(usuario.getPassword()).roles("USER").build();
    }
}