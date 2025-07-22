package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.Artista;

import java.util.Optional;

public interface ArtistaRepository {
    Optional<Artista> findById(Integer id);
}
