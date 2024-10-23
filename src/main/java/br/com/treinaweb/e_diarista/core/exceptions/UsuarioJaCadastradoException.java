package br.com.treinaweb.e_diarista.core.exceptions;

import org.springframework.validation.FieldError;

public class UsuarioJaCadastradoException extends ValidacaoException{
    public UsuarioJaCadastradoException(String message, FieldError fieldError) {
        super(message, fieldError); 
    }
}
