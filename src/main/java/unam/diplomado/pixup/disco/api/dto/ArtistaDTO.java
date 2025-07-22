package unam.diplomado.pixup.disco.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistaDTO {
    @NotNull(message = "El ID del artista es requerido")
    private Integer id;
}
