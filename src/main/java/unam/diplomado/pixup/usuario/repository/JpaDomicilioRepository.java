package unam.diplomado.pixup.usuario.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.usuario.domain.Domicilio;

@Singleton
public class JpaDomicilioRepository implements DomicilioRepository {

    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Domicilio save(Domicilio domicilio) {
        entityManager.persist(domicilio);
        return domicilio;
    }

}
