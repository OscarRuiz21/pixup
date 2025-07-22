package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioDTO {

    @NotBlank(message="Calle es requerida")
    private String calle;
    private String numExterior;
    private String numInterior;
    @NotNull(message="Colonia es requerida")
    private Integer colonia;
    private Integer tipoDomicilio;

}
