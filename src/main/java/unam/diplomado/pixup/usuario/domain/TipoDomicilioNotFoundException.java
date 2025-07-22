package unam.diplomado.pixup.usuario.domain;

public class TipoDomicilioNotFoundException extends RuntimeException {

    public TipoDomicilioNotFoundException(Integer id) {
        super("No se encontró un tipo domicilio con id: " + id);
    }

}

