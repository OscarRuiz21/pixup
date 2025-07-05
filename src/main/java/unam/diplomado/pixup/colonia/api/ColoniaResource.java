package unam.diplomado.pixup.colonia.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.Colonia;
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

}