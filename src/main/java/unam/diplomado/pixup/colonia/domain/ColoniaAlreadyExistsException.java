package unam.diplomado.pixup.colonia.domain;

public class ColoniaAlreadyExistsException extends RuntimeException {

    public ColoniaAlreadyExistsException(String cp, String nombre) {
        super("Ya existe una colonia con el cp: " + cp + " y nombre: " + nombre);
    }

}
