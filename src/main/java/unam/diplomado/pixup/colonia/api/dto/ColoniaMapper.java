package unam.diplomado.pixup.colonia.api.dto;

import jakarta.inject.Singleton;
import unam.diplomado.pixup.colonia.domain.Colonia;

@Singleton
public class ColoniaMapper {

    public ColoniaDTO toDto(Colonia colonia) {
        return new ColoniaDTO(
                colonia.getId(), colonia.getNombre(), colonia.getCp(),
                colonia.getMunicipio().getNombre(),
                colonia.getMunicipio().getEstado().getNombre());
    }

}