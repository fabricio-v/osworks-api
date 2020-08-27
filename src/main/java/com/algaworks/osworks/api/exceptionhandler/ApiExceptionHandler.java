/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.algaworks.osworks.api.exceptionhandler;

import com.algaworks.osworks.domain.exception.NegocioException;
import com.algaworks.osworks.domain.model.Cliente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Fabricio
 */
@ControllerAdvice //diz que é um componente do Spring, porém é um componente onde iremos colocar o tratamento de Exceptions de todos os controladores
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    
    @Autowired
    private MessageSource messageSource;
    
    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        
        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitulo(ex.getMessage());
        problema.setDataHora(LocalDateTime.now());
        
        return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
        
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Problema.Campo> campos = new ArrayList<>();
        
        for(ObjectError error : ex.getBindingResult().getAllErrors()){
            String campo = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
            
            campos.add(new Problema.Campo(campo, mensagem));
        }
        
        Problema problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitulo("Um ou mais campos estão invalidos. Faça o preenchimento correto e tente novamente.");
        problema.setDataHora(LocalDateTime.now());
        problema.setCampos(campos);

        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }

}
