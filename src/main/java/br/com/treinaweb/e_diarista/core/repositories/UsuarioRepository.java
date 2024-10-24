package br.com.treinaweb.e_diarista.core.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.treinaweb.e_diarista.core.models.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT count(*) > 0 FROM Usuario u WHERE u.email = :email and (:id is null or u.id != :id) ")
    Boolean isEmailJaCadastrado(String email, Long id);
}
