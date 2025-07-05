package unam.diplomado.pixup.colonia.domain;

public class MunicipioNotFoundException extends RuntimeException {

    public MunicipioNotFoundException(Integer id) {
        super("No existe el municipio con id: " + id);
    }

}
