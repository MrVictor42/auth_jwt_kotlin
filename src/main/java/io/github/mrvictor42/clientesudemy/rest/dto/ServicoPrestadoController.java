package io.github.mrvictor42.clientesudemy.rest.dto;

import io.github.mrvictor42.clientesudemy.model.entity.Cliente;
import io.github.mrvictor42.clientesudemy.model.entity.ServicoPrestado;
import io.github.mrvictor42.clientesudemy.repository.ClienteRepository;
import io.github.mrvictor42.clientesudemy.repository.ServicoPrestadoRepository;
import io.github.mrvictor42.clientesudemy.rest.ServicoPrestadoDTO;
import io.github.mrvictor42.clientesudemy.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servico-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();
        Cliente cliente =
                clienteRepository
                    .findById(idCliente)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));


        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getValor()));
        servicoPrestado.setCliente(cliente);

        return servicoPrestadoRepository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes) {
        return servicoPrestadoRepository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }
}
