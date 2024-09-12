package br.com.treinaweb.e_diarista.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.e_diarista.core.models.Servico;

public interface ServicoRepository extends JpaRepository <Servico, Long> {
    
}
