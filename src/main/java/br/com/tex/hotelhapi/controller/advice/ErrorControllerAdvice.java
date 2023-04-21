package br.com.tex.hotelhapi.controller.advice;

import br.com.tex.hotelhapi.model.dto.erro.ErroOutputDto;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.persistence.EntityNotFoundException;
import java.util.List;
@RestControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity erroNotFound(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity erroNotFoundDelete(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity erroBadRequest(MethodArgumentNotValidException ex){
        List<ErroOutputDto> errosDto =
                ex.getFieldErrors().stream()
                        .map(e -> new ErroOutputDto(e.getField(),e.getDefaultMessage())).toList();

        return ResponseEntity.badRequest().body(errosDto);
    }
}
