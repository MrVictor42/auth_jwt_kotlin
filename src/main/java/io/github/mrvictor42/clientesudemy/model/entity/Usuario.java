package io.github.mrvictor42.clientesudemy.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, name = "login")
    @NotEmpty(message = "{login.obrigatorio}")
    private String username;
    @Column(name = "senha")
    @NotEmpty(message = "{senha.obrigatorio}")
    private String password;
}
