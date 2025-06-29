package unam.diplomado.pixup.usuario.repository;

import unam.diplomado.pixup.usuario.domain.TipoDomicilio;

import java.util.Collection;
import java.util.Optional;

public interface TipoDomicilioRepository {

    Collection<TipoDomicilio> findAll();

    Optional<TipoDomicilio> findById(Integer id);

}
