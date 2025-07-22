package unam.diplomado.pixup.colonia.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.api.dto.ColoniaDTO;
import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("colonias")
public interface ColoniaApi {
    @GET //Por defecto regresa un código HTTP 200, por lo que no es necesario armar un Response
    @Path("{id}")
    Colonia getColoniaById(@PathParam("id") Integer id); //path param --> /colonias/2

    @GET //Por defecto regresa un código HTTP 200, por lo que no es necesario armar un Response
    Collection<ColoniaDTO> getColoniasByCp(@NotBlank @QueryParam("cp") String cp); //query param --> /colonias?cp=56400

    @DELETE //Por defecto regresa un código HTTP 204, por lo que no es necesario armar un Response
    @Path("{id}")
    void deleteColonia(@PathParam("id") Integer id);

    @POST //Por defecto regresa un código HTTP 200, por lo que hay que crear un Response para regresar un 201 de creado
    Response createColonia(@NotNull @Valid Colonia colonia); //Si no se cumplen las reglas de Validator, regresa un código 400

    @PUT //Por defecto regresa un código HTTP 200, por lo que no es necesario armar un Response
    @Path("{id}")
    Colonia updateColonia(@PathParam("id") Integer id, Colonia colonia);
}
