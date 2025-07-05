package unam.diplomado.pixup.colonia.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.colonia.domain.Municipio;

import java.util.Optional;

@Singleton
public class JpaMunicipioRepository implements MunicipioRepository {

    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Municipio> findById(Integer id) {
        Municipio municipio = entityManager.find(Municipio.class, id);
        return municipio != null ? Optional.of(municipio) : Optional.empty();
    }

}
