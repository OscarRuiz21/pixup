package unam.diplomado.pixup.disco.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.disco.domain.exceptions.DiscoAlreadyExistsException;
import unam.diplomado.pixup.usuario.api.exception.ErrorResponse;
import unam.diplomado.pixup.usuario.domain.UsuarioAlreadyExistException;

@Provider
public class DiscoAlreadyExistExceptionMapper implements ExceptionMapper<DiscoAlreadyExistsException> {

    @Override
    public Response toResponse(DiscoAlreadyExistsException e) {
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

