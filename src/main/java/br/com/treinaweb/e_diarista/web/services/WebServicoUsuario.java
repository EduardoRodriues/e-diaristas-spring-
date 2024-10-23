package br.com.treinaweb.e_diarista.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import br.com.treinaweb.e_diarista.core.enums.TipoUsuario;
import br.com.treinaweb.e_diarista.core.exceptions.SenhaIncorretaException;
import br.com.treinaweb.e_diarista.core.exceptions.SenhasNaoConferemException;
import br.com.treinaweb.e_diarista.core.exceptions.UsuarioJaCadastradoException;
import br.com.treinaweb.e_diarista.core.exceptions.UsuarioNaoEncontradoException;
import br.com.treinaweb.e_diarista.core.models.Usuario;
import br.com.treinaweb.e_diarista.core.repositories.UsuarioRepository;
import br.com.treinaweb.e_diarista.web.dtos.AlterarSenhaForm;
import br.com.treinaweb.e_diarista.web.dtos.UsuarioCadastroForm;
import br.com.treinaweb.e_diarista.web.dtos.UsuarioFormEdicao;
import br.com.treinaweb.e_diarista.web.interfaces.IconfirmacaoSenha;
import br.com.treinaweb.e_diarista.web.mappers.WebUsuarioMapper;

@Service
public class WebServicoUsuario {
   
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private WebUsuarioMapper mapper; 
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Usuario cadastrar(UsuarioCadastroForm form) {

       validarConfirmacaoSenha(form);

        var model = mapper.toModel(form);

        var senhaHash = passwordEncoder.encode(model.getSenha());


        model.setSenha(senhaHash);
        model.setTipoUsuario(TipoUsuario.ADMIN);

        validarCamposUnicos(model);

        return repository.save(model);
    }

    public Usuario buscarPorId(Long id) {
        var mensagem = String.format("Usuario com ID %d nao encontrado",id);

        return repository.findById(id)
        .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public Usuario buscarPorEmail(String email) {
        var mensagem = String.format("Email com ID %d nao encontrado",email);

        return repository.findByEmail(email)
        .orElseThrow(() -> new UsuarioNaoEncontradoException(mensagem));
    }

    public UsuarioFormEdicao buscarFormPorId(Long id) {
        var usuario = buscarPorId(id);

        return mapper.toForm(usuario);
    }

    public Usuario editar(UsuarioFormEdicao form, Long id) {
        var usuario = buscarPorId(id);

        var model = mapper.toModel(form);
        model.setId(usuario.getId());
        model.setSenha(usuario.getSenha());
        model.setTipoUsuario(usuario.getTipoUsuario());

        validarCamposUnicos(model);

        return repository.save(model);
    }

    public void excluirPorId(Long id) {
        var usuario = buscarPorId(id);

        repository.delete(usuario );
    }

    public void alterarSenha(AlterarSenhaForm form, String email) {
        var usuario = buscarPorEmail(email);

        var senhaAtual = usuario.getSenha();
        var senhaAntiga = form.getSenhaAntiga();
        var senha = form.getSenha();

        validarConfirmacaoSenha(form);

        if(!passwordEncoder.matches(senhaAntiga, senhaAtual)) {
            var menssagem = "senha antiga nao confere";

            var fieldError = new FieldError(form.getClass().getName(),
             "senhaAntiga", senhaAntiga,
              false,
               null,
                null,
                 menssagem);

                 throw new SenhaIncorretaException(menssagem, fieldError);
        }

        var novaSenhaHash =passwordEncoder.encode(senha);
        usuario.setSenha(novaSenhaHash);

        repository.save(usuario);

    }

    private void validarConfirmacaoSenha(IconfirmacaoSenha obj) {
        var senha = obj.getSenha();
        var confirmacaoSenha = obj.getConfirmacaoSenha();

        if(!senha.equals(confirmacaoSenha)) {
            var menssagem = "os dois campos de senhas nao conferem";

            var fieldError = new FieldError(obj.getClass().getName(),
             "confirmacaoSenha", obj.getConfirmacaoSenha(),
              false,
               null,
                null,
                 menssagem);

                 throw new SenhasNaoConferemException(menssagem, fieldError);
        }
    }

    private void validarCamposUnicos(Usuario usuario) {

        if(repository.isEmailJaCadastrado(usuario.getEmail(), usuario.getId())) {
            var menssagem = "este email já foi cadastrado";

            var fieldError = new FieldError(usuario.getClass().getName(),
             "email", usuario.getEmail(),
              false,
               null,
                null,
                 menssagem);

                 throw new UsuarioJaCadastradoException(menssagem, fieldError);
        }
    }
}
