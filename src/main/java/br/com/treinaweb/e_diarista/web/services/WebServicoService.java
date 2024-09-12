package br.com.treinaweb.e_diarista.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.e_diarista.core.exceptions.ServicoNaoEncontradoException;
import br.com.treinaweb.e_diarista.core.models.Servico;
import br.com.treinaweb.e_diarista.core.repositories.ServicoRepository;
import br.com.treinaweb.e_diarista.web.dtos.ServicoForm;
import br.com.treinaweb.e_diarista.web.mappers.WebServicoMapper;

@Service
public class WebServicoService {
    
    @Autowired
    private ServicoRepository repository;

    @Autowired
    private WebServicoMapper mapper;

    public List <Servico> buscartodos() {
        return repository.findAll();
    }

    public Servico cadastrar(ServicoForm form) {
        var model = mapper.toModel(form);

        return repository.save(model);
    }

    public Servico buscarPorId(Long id) {
        var servicoEncontrado = repository.findById(id);

        if(servicoEncontrado.isPresent()) {
            return servicoEncontrado.get();
        }

        var mensagem = String.format("Serviço com ID %d não encontrado! ", id);

        throw new ServicoNaoEncontradoException(mensagem);
    }

    public Servico editar(ServicoForm form, Long id) {
        var servicoEcontrado = buscarPorId(id);

        var model = mapper.toModel(form);
        model.setId(servicoEcontrado.getId());

        return repository.save(model);

    }

    public void excluirPorId(Long id) {
        var servicoEcontrado = buscarPorId(id);

        repository.delete(servicoEcontrado);
    }
}
