package br.com.treinaweb.e_diarista.web.dtos;

import br.com.treinaweb.e_diarista.web.interfaces.IconfirmacaoSenha;
import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotEmpty;

public class AlterarSenhaForm implements IconfirmacaoSenha {
    
    @NonNull
    @NotEmpty
    private String senhaAntiga;

    @NonNull
    @NotEmpty
    private String senha;

    @NonNull
    @NotEmpty
    private String confirmacaoSenha;

    public AlterarSenhaForm(String senhaAntiga, String senha, String confirmacaoSenha) {
        this.senhaAntiga = senhaAntiga;
        this.senha = senha;
        this.confirmacaoSenha = confirmacaoSenha;
    }

    public AlterarSenhaForm() {
    }

    public String getSenhaAntiga() {
        return senhaAntiga;
    }

    public void setSenhaAntiga(String senhaAntiga) {
        this.senhaAntiga = senhaAntiga;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmacaoSenha() {
        return confirmacaoSenha;
    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        this.confirmacaoSenha = confirmacaoSenha;
    }
}
