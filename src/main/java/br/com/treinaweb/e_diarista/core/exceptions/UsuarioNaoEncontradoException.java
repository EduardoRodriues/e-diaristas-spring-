package br.com.treinaweb.e_diarista.core.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class UsuarioNaoEncontradoException extends EntityNotFoundException{
    
    public UsuarioNaoEncontradoException(String message) {
        super(message); 
    }
}
