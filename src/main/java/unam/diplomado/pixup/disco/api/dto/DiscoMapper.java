package unam.diplomado.pixup.disco.api.dto;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.repository.ArtistaRepository;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;
import unam.diplomado.pixup.disco.repository.GeneroMusicalRepository;

import java.time.ZonedDateTime;

@ApplicationScoped
public class DiscoMapper {

    @Inject
    ArtistaRepository artistaRepository;

    @Inject
    DisqueraRepository disqueraRepository;

    @Inject
    GeneroMusicalRepository generoMusicalRepository;

    public Disco toEntity(DiscoDTO dto) {
        Disco disco = new Disco();
        disco.setTitulo(dto.getTitulo());
        disco.setPrecio(dto.getPrecio());
        disco.setExistencia(dto.getExistencia());
        disco.setDescuento(dto.getDescuento());
        disco.setImagen(dto.getImagen());
        disco.setFechaLanzamiento(ZonedDateTime.parse(dto.getFechaLanzamiento()));
        disco.setArtista(artistaRepository.findById(dto.getArtista().getId()).orElseThrow());
        disco.setDisquera(disqueraRepository.findById(dto.getDisquera().getId()).orElseThrow());
        disco.setGeneroMusical(generoMusicalRepository.findById(dto.getGeneroMusical().getId()).orElseThrow());
        return disco;
    }

    public DiscoResponseDTO toDiscoResponseDTO(Disco disco){
        DiscoResponseDTO response = new DiscoResponseDTO();
        response.setId(disco.getId());
        response.setTitulo(disco.getTitulo());
        response.setPrecio(disco.getPrecio());
        response.setExistencia(disco.getExistencia());
        response.setDescuento(disco.getDescuento());
        response.setFechaLanzamiento(disco.getFechaLanzamiento().toString());
        response.setImagen(disco.getImagen());

        ArtistaDTO artistaDTO = new ArtistaDTO();
        artistaDTO.setId(disco.getArtista().getId());
        response.setArtista(artistaDTO);

        DisqueraDTO disqueraDTO = new DisqueraDTO();
        disqueraDTO.setId(disco.getDisquera().getId());
        response.setDisquera(disqueraDTO);

        GeneroMusicalDTO generoDTO = new GeneroMusicalDTO();
        generoDTO.setId(disco.getGeneroMusical().getId());
        response.setGeneroMusical(generoDTO);

        return response;
    }
}
