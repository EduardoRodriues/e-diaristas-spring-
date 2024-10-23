package br.com.treinaweb.e_diarista.web.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.treinaweb.e_diarista.core.models.Usuario;
import br.com.treinaweb.e_diarista.web.dtos.UsuarioCadastroForm;
import br.com.treinaweb.e_diarista.web.dtos.UsuarioFormEdicao;


@Mapper(componentModel = "spring")
public interface WebUsuarioMapper {
    
    WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    Usuario toModel(UsuarioCadastroForm form);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tipoUsuario", ignore = true)
    @Mapping(target = "senha", ignore = true)
    Usuario toModel(UsuarioFormEdicao form);

    UsuarioFormEdicao toForm(Usuario model);
}
