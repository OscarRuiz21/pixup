package unam.diplomado.pixup.colonia.repository;

import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Singleton
public class JpaColoniaRepository implements ColoniaRepository {

    @PersistenceContext(unitName="pixup")
    private EntityManager entityManager;

    @Override
    public Collection<Colonia> findByCp(String cp) {
        TypedQuery<Colonia> query = entityManager.createQuery(
                "SELECT c FROM Colonia c WHERE c.cp = ?1", Colonia.class);
        query.setParameter(1, cp);
        return query.getResultList();
    }

    @Override
    public Optional<Colonia> findById(Integer id) {
        Colonia colonia = entityManager.find(Colonia.class, id);
        return colonia != null ? Optional.of(colonia) : Optional.empty();
    }

    @Override
    public Colonia saveOrUpdate(Colonia colonia) {
        entityManager.persist(colonia);
        return colonia;
    }

    @Override
    public void delete(Colonia colonia) {
        entityManager.remove(colonia);
    }

    @Override
    public Optional<Colonia> findByCpAndNombre(String cp, String nombre) {
        TypedQuery<Colonia> query = entityManager.createQuery(
                "SELECT c FROM Colonia c WHERE c.cp = :cp AND c.nombre = :nombre", Colonia.class);
        query.setParameter("cp", cp);
        query.setParameter("nombre", nombre);
        List<Colonia> colonias = query.getResultList();
        return !colonias.isEmpty() ? Optional.of(colonias.get(0)) : Optional.empty();
    }

}
