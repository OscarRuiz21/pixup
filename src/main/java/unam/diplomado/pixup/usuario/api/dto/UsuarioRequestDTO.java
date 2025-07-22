package unam.diplomado.pixup.usuario.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message="Nombre es requerido")
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String password;
    @Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
            message="Formato no válido para Email")
    private String email;
    private String rfc;

}
