package unam.diplomado.pixup.web;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import unam.diplomado.pixup.colonia.api.dto.ColoniaDTO;
import unam.diplomado.pixup.colonia.api.dto.ColoniaMapper;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.usuario.domain.Domicilio;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;
import unam.diplomado.pixup.usuario.domain.Usuario;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;
import unam.diplomado.pixup.usuario.service.UsuarioService;

import java.io.Serializable;
import java.util.Collection;

@Named("registro") //Nombre de referencia en las vistas
@ViewScoped //Mantiene toda la información en la vista hasta que haya una transición
@Log
@Data
@NoArgsConstructor
public class RegistroUsuarioController implements Serializable {

    // Input
    private Usuario usuario;
    private Domicilio domicilio;
    private String cp;
    private String coloniaId;
    private String tipoDomicilioId;

    // Output
    private Collection<TipoDomicilio> tiposDomicilio;
    private Collection<ColoniaDTO> colonias;

    @Inject
    transient private UsuarioService usuarioService;
    @Inject
    transient private ColoniaRepository coloniaRepository;
    @Inject
    transient private TipoDomicilioRepository tipoDomicilioRepository;
    @Inject
    transient private ColoniaMapper coloniaMapper;

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.domicilio = new Domicilio();
        this.tiposDomicilio = tipoDomicilioRepository.findAll();
    }

    public void findColoniaByCp() {
        log.info("colonia seleccionada: " + cp);
        colonias = coloniaRepository.findByCp(cp)
                .stream()
                .map(colonia -> coloniaMapper.toDto(colonia))
                .toList();
    }

    public String altaUsuario() {
        domicilio.setColonia(new Colonia());
        domicilio.setTipoDomicilio(new TipoDomicilio());
        domicilio.getColonia().setId(Integer.valueOf(coloniaId));
        domicilio.getTipoDomicilio().setId(Integer.valueOf(tipoDomicilioId));

        Usuario usuarioCreado = usuarioService.registrarUsuario(usuario, domicilio);
        log.info("Usuario Creado: " + usuarioCreado);

        return "/registro_resultado?faces-redirect=true";
    }
}
