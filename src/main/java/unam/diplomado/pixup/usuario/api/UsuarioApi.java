package unam.diplomado.pixup.usuario.api;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.usuario.api.dto.RegistroUsuarioDTO;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("usuarios")
public interface UsuarioApi {

    @POST
    @Path("registro")
    Response registrarUsuario(@NotNull @Valid RegistroUsuarioDTO registroUsuarioDTO);

}
