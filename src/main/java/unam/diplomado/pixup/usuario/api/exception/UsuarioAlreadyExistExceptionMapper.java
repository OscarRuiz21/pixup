package unam.diplomado.pixup.usuario.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.usuario.domain.UsuarioAlreadyExistException;

@Provider
public class UsuarioAlreadyExistExceptionMapper implements ExceptionMapper<UsuarioAlreadyExistException> {

    @Override
    public Response toResponse(UsuarioAlreadyExistException e) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(
                        new ErrorResponse(
                                Response.Status.CONFLICT.getStatusCode(),
                                "BUSINESS_RULE",
                                e.getMessage()
                        )
                )
                .build();
    }
}
