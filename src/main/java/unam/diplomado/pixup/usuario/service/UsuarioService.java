package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;

@Local
public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);

}
