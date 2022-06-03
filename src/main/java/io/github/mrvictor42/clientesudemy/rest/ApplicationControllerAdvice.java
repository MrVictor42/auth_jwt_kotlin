package io.github.mrvictor42.clientesudemy.rest;

import io.github.mrvictor42.clientesudemy.exception.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleValidationErros(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        List<String> messages =
                bindingResult
                        .getAllErrors()
                        .stream()
                        .map(objectError -> objectError.getDefaultMessage())
                        .collect(Collectors.toList());

        return new ApiErros(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException exception) {
        String messageError = exception.getReason();
        HttpStatus codigoStatus = exception.getStatus();
        ApiErros apiErros = new ApiErros(messageError);

        return new ResponseEntity(apiErros, codigoStatus);
    }
}
