package unam.diplomado.pixup.disco.repository;

import unam.diplomado.pixup.disco.domain.GeneroMusical;

import java.util.Optional;

public interface GeneroMusicalRepository {
    Optional<GeneroMusical> findById(Integer id);
}
