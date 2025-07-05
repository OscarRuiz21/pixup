package unam.diplomado.pixup.colonia.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaAlreadyExistsException;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;
import unam.diplomado.pixup.colonia.service.ColoniaService;

import java.util.Collection;
import java.util.Optional;

public class ColoniaResource implements ColoniaApi {

    @Inject
    private ColoniaRepository coloniaRepository;
    @Inject
    private ColoniaService coloniaService;

    @Override
    public Response getColoniaById(Integer id) {
        try {
            Colonia colonia = coloniaService.obtenerColoniaPorId(id);
            return Response
                    .status(Response.Status.OK)
                    .entity(colonia)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(e.getCause().getMessage())
                    .build();
        }
        /*
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()) {
            return Response
                    .status(Response.Status.OK)
                    .entity(colonia.get())
                    .build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(null)
                .build();
         */
    }

    @Override
    public Collection<Colonia> getColoniasByCp(String cp) {
        return coloniaRepository.findByCp(cp);
    }

    @Override
    public Response createColonia(Colonia colonia) {
        try {
            Colonia coloniaCreada = coloniaService.crearColonia(colonia);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(coloniaCreada)
                    .build();
        } catch (Exception e) {
            if (e.getCause() instanceof ColoniaAlreadyExistsException) {
                return Response
                        .status(Response.Status.CONFLICT)
                        .entity(e.getCause().getMessage())
                        .build();
            }
            return Response
                    .status(Response.Status.PRECONDITION_REQUIRED)
                    .entity(e.getCause().getMessage())
                    .build();
        }
    }

    @Override
    public void deleteColonia(Integer id) {

    }

    @Override
    public Colonia updateColonia(Integer id, Colonia colonia) {
        return null;
    }

}