package unam.diplomado.pixup.colonia.repository;

import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;
import java.util.Optional;

public interface ColoniaRepository {

    Collection<Colonia> findByCp(String cp);
    Optional<Colonia> findById(Integer id);
    Colonia saveOrUpdate(Colonia colonia);
    void delete(Colonia colonia);
    Optional<Colonia> findByCpAndNombre(String cp, String nombre);

}
