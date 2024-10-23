package br.com.treinaweb.e_diarista.auth.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.treinaweb.e_diarista.core.models.Usuario;
import lombok.Getter;

@Getter
public class UsuarioAutenticado implements UserDetails{

    private Usuario usuario;

    

	public UsuarioAutenticado(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioAutenticado() {
    }

    public Usuario getUsuario() {
		return usuario;
	}

	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return AuthorityUtils.createAuthorityList(usuario.getTipoUsuario().toString());
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getEmail();
    }
    
}
