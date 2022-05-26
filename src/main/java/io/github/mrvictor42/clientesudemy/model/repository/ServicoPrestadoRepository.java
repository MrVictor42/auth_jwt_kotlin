package io.github.mrvictor42.clientesudemy.model.repository;

import io.github.mrvictor42.clientesudemy.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    /*
        Selecione os serviços prestados, fazendo join com o cliente, onde o nome do cliente
        é parecido com o nome do parametro (neste caso, usando o upper, tanto faz em caixa alta
        ou baixa, e o mês é o mesmo do parametro
     */
    @Query("SELECT servico FROM ServicoPrestado servico JOIN servico.cliente cliente " +
            "WHERE UPPER(cliente.nome) LIKE UPPER(:nome) AND MONTH(servico.data) = :mes")
    List<ServicoPrestado> findByNomeClienteAndMes(
            @Param("nome") String nome, @Param("mes") Integer mes);
}
