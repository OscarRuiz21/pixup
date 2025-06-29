package unam.diplomado.pixup.usuario.api;
import jakarta.inject.Inject;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;

import java.util.Collection;

public class TipoDomicilioResource implements TipoDomicilioApi {

    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;

    @Override
    public Collection<TipoDomicilio> getAll() {
        return tipoDomicilioRepository.findAll();
    }

}
