package br.com.treinaweb.e_diarista.core.exceptions;

import org.springframework.validation.FieldError;

public class SenhasNaoConferemException extends ValidacaoException{
    
    public SenhasNaoConferemException(String message, FieldError fieldError) {
        super(message, fieldError);
    }
}
