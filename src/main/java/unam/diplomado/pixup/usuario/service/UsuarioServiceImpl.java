package unam.diplomado.pixup.usuario.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.usuario.domain.*;
import unam.diplomado.pixup.usuario.repository.DomicilioRepository;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.pixup.usuario.repository.UsuarioRepository;

import java.util.Optional;

@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    @Inject
    private UsuarioRepository usuarioRepository;
    @Inject
    private DomicilioRepository domicilioRepository;
    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED) //Evitar encadenamiento de transacciones
    public Usuario registrarUsuario(Usuario usuario, Domicilio domicilio) {
        //Validar que no exista el usuario
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if(usuarioExistente.isPresent()){
            throw new UsuarioAlreadyExistException(usuario.getEmail());
        }

        //Validar que exista la colonia
        Optional<Colonia> colonia = coloniaRepository.findById(domicilio.getColonia().getId());
        if(colonia.isEmpty()){
            throw new ColoniaNotFoundException(domicilio.getColonia().getId());
        }
        domicilio.setColonia(colonia.get());

        //Validar que exista el tipo de domicilio
        Optional<TipoDomicilio> tipoDomicilio = tipoDomicilioRepository.findById(domicilio.getTipoDomicilio().getId());
        if(tipoDomicilio.isEmpty()){
            throw new TipoDomicilioNotFoundException(domicilio.getTipoDomicilio().getId());
        }
        domicilio.setTipoDomicilio(tipoDomicilio.get());

        //Persistencia o guardado de entidades
        usuarioRepository.save(usuario);
        domicilio.setUsuario(usuario);
        domicilioRepository.save(domicilio);

        return usuario;
    }
}
