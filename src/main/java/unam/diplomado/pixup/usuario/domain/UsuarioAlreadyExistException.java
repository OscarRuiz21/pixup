package unam.diplomado.pixup.usuario.domain;

public class UsuarioAlreadyExistException extends RuntimeException {

    public UsuarioAlreadyExistException(String email) {
        super("Ya existe el usuario con email: " + email);
    }

}
