package unam.diplomado.pixup.disco.api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroMusicalDTO {
    @NotNull(message = "El ID del genero musical es requerido")
    private Integer id;
}