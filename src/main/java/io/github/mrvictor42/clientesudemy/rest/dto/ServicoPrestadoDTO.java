package io.github.mrvictor42.clientesudemy.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {
    @NotEmpty(message = "{descricao.obrigatoria}")
    private String descricao;
    @NotEmpty(message = "{valor.obrigatoria}")
    private String valor;
    @NotEmpty(message = "{data.obrigatoria}")
    private String data;
    @NotNull(message = "{cliente.obrigatorio}")
    private Integer idCliente;
}