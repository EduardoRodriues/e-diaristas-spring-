package br.com.treinaweb.e_diarista.core.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class ServicoNaoEncontradoException extends EntityNotFoundException {
    
    public ServicoNaoEncontradoException(String message) {
        super(message);
    }
}
