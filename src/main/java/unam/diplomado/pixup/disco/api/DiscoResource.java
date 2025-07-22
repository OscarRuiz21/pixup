package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.exceptions.ArtistaNotFoundException;
import unam.diplomado.pixup.disco.domain.exceptions.DiscoAlreadyExistsException;
import unam.diplomado.pixup.disco.domain.exceptions.DisqueraNotFoundException;
import unam.diplomado.pixup.disco.domain.exceptions.GeneroMusicalNotFoundException;
import unam.diplomado.pixup.disco.service.DiscoService;

public class DiscoResource implements DiscoApi{

    @Inject
    private DiscoService discoService;

    @Override
    public Response altaDiscos(Disco disco) {
        try {
            Disco discoSaved = discoService.registrarDisco(disco);
            return Response.status(Response.Status.CREATED).entity(discoSaved).build();
        } catch (DiscoAlreadyExistsException discoAlreadyExistsException) {
            return Response.status(Response.Status.CONFLICT).build();
        } catch(DisqueraNotFoundException | ArtistaNotFoundException | GeneroMusicalNotFoundException nfe){
                return Response.status(Response.Status.PRECONDITION_REQUIRED).build();
        } catch (IllegalArgumentException ipe) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } catch (Exception E){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
