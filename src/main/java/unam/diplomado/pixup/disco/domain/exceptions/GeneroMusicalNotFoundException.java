package unam.diplomado.pixup.disco.domain.exceptions;

public class GeneroMusicalNotFoundException extends RuntimeException {

    public GeneroMusicalNotFoundException(Integer id) {
        super("No se encontró al genero musical con id: " + id);
    }

}
