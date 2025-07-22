package unam.diplomado.pixup.usuario.service;

import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario, Domicilio domicilio);

}
