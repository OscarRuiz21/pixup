package unam.diplomado.pixup.usuario.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;

@Singleton
public class RegistroUsuarioMapper {

    public UsuarioResponseDTO toDto(Usuario usuario) {
        return new UsuarioResponseDTO(usuario.getId(), usuario.getEmail());
    }

    public Usuario toUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        return new Usuario(
                null, usuarioRequestDTO.getNombre(), usuarioRequestDTO.getPrimerApellido(),
                usuarioRequestDTO.getSegundoApellido(), usuarioRequestDTO.getPassword(),
                usuarioRequestDTO.getEmail(), usuarioRequestDTO.getRfc());
    }

    public Domicilio toDomicilio(DomicilioDTO domicilioDTO) {
        return new Domicilio(
                domicilioDTO.getCalle(), domicilioDTO.getNumExterior(),
                domicilioDTO.getNumInterior(), domicilioDTO.getColonia(),
                domicilioDTO.getTipoDomicilio());
    }

}
