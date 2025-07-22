package unam.diplomado.pixup.disco.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.domain.GeneroMusical;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscoDTO {

    @NotBlank(message = "El título es requerido")
    private String titulo;

    @NotNull(message = "El precio es requerido")
    @PositiveOrZero(message = "El precio no puede ser negativo")
    private Double precio;

    @NotNull(message = "La existencia es requerida")
    @PositiveOrZero(message = "La existencia no puede ser negativa")
    private Integer existencia;

    @NotNull(message = "El descuento es requerido")
    @PositiveOrZero(message = "El descuento no puede ser negativo")
    private Double descuento;

    @NotBlank(message = "La imagen es requerida")
    private String imagen;

    @NotBlank(message = "La fecha de lanzamiento es requerida")
    private String fechaLanzamiento;

    @NotNull(message = "El artista es requerido")
    private ArtistaDTO artista;

    @NotNull(message = "La disquera es requerido")
    private DisqueraDTO disquera;

    @NotNull(message = "El género musical es requerido")
    private GeneroMusicalDTO GeneroMusical;
}
