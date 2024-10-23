package br.com.treinaweb.e_diarista.web.dtos;

import br.com.treinaweb.e_diarista.web.interfaces.IconfirmacaoSenha;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCadastroForm implements IconfirmacaoSenha {
    
    @NotNull
    @Size(min = 3, max = 255)
    private String nomeCompleto;

    @NotNull
    @Size(min = 3, max = 255)
    @Email
    private String email;

    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private String confirmacaoSenha;

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nome) {
		this.nomeCompleto = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
