package unam.diplomado.pixup.disco.domain.exceptions;

public class ArtistaNotFoundException extends RuntimeException {

    public ArtistaNotFoundException(Integer id) {
        super("No se encontró al artista con id: " + id);
    }

}
