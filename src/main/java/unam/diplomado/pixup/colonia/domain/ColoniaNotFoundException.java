package unam.diplomado.pixup.colonia.domain;

public class ColoniaNotFoundException extends RuntimeException {

    public ColoniaNotFoundException(Integer id) {
        super("No se encontró la colonia con id: " + id);
    }

}
