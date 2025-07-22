package unam.diplomado.pixup.disco.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.disco.api.dto.DiscoDTO;
import unam.diplomado.pixup.disco.api.dto.DiscoMapper;
import unam.diplomado.pixup.disco.api.dto.DiscoResponseDTO;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.service.DiscoService;

public class DiscoResource implements DiscoApi{

    @Inject
    private DiscoService discoService;
    @Inject
    private DiscoMapper discoMapper;

    @Override
    public Response altaDiscos(DiscoDTO discoDto) {

        Disco discoToSave = discoMapper.toEntity(discoDto);
        Disco discoSaved = discoService.registrarDisco(discoToSave);
        DiscoResponseDTO discoResponseDTO = discoMapper.toDiscoResponseDTO(discoSaved);

        return Response
                .status(Response.Status.CREATED)
                .entity(discoResponseDTO)
                .build();
    }
}
