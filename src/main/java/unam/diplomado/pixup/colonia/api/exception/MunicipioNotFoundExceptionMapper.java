package unam.diplomado.pixup.colonia.api.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import unam.diplomado.pixup.colonia.domain.MunicipioNotFoundException;

@Provider
public class MunicipioNotFoundExceptionMapper
        implements ExceptionMapper<MunicipioNotFoundException> {

    @Override
    public Response toResponse(MunicipioNotFoundException e) {
        return Response
                .status(Response.Status.PRECONDITION_REQUIRED)
                .entity(e.getMessage())
                .build();
    }

}
