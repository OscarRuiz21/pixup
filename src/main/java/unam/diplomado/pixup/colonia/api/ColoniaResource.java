package unam.diplomado.pixup.colonia.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.api.dto.ColoniaDTO;
import unam.diplomado.pixup.colonia.api.dto.ColoniaMapper;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaAlreadyExistsException;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.colonia.service.ColoniaService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class ColoniaResource implements ColoniaApi {

    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private ColoniaService coloniaService;
    @Inject
    private ColoniaMapper coloniaMapper;

    @Override
    public Colonia getColoniaById(Integer id) {
        return coloniaService.obtenerColoniaPorId(id);
    }

    @Override
    public Collection<ColoniaDTO> getColoniasByCp(String cp) {
        /*
        Collection<Colonia> colonias = coloniaRepository.findByCp(cp);
        Collection<ColoniaDTO> coloniasDTO = new ArrayList<>();
        for (Colonia colonia: colonias) {
            coloniasDTO.add(coloniaMapper.toDto(colonia));
        }
        return coloniasDTO;
        */
        return coloniaRepository.findByCp(cp)
                .stream()
                .map(colonia -> coloniaMapper.toDto(colonia))
                .toList();
    }

    @Override
    public Response createColonia(Colonia colonia) {
        Colonia coloniaCreada = coloniaService.crearColonia(colonia);
        return Response.status(Response.Status.CREATED).entity(coloniaCreada).build();
    }

    @Override
    public void deleteColonia(Integer id) {
        coloniaService.eliminarColoniaPorId(id);
    }

    @Override
    public Colonia updateColonia(Integer id, Colonia colonia) {
        colonia.setId(id);
        return coloniaService.actualizarColonia(colonia);
    }

}