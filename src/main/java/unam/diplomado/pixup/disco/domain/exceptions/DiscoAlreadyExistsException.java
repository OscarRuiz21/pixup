package unam.diplomado.pixup.disco.domain.exceptions;

public class DiscoAlreadyExistsException extends RuntimeException {

    public DiscoAlreadyExistsException(String title) {
        super("El disco con titulo: " + title + " ya existe ");
    }

}
