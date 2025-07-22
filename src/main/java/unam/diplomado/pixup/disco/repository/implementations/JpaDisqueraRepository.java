package unam.diplomado.pixup.disco.repository.implementations;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.disco.domain.Disquera;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;

import java.util.Optional;

@Singleton
public class JpaDisqueraRepository implements DisqueraRepository {
    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disquera> findById(Integer id) {
        Disquera disquera = entityManager.find(Disquera.class, id);
        return Optional.ofNullable(disquera);
    }
}
