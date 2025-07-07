package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.repository.DomicilioRepository;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.UsuarioRepository;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private DomicilioRepository domicilioRepository;
    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {


        return null;
    }

}
