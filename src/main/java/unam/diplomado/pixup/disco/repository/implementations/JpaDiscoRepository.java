package unam.diplomado.pixup.disco.repository.implementations;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.repository.DiscoRepository;

import java.util.Optional;

@Singleton
public class JpaDiscoRepository implements DiscoRepository {
    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Disco> findByTituloAndArtista(String titulo, Integer idArtista) {
        TypedQuery<Disco> query = entityManager.createQuery("SELECT d FROM Disco d WHERE d.titulo = :titulo AND d.artista.id = :idArtista", Disco.class);
        query.setParameter("titulo", titulo);
        query.setParameter("idArtista", idArtista);
        Disco disco = query.getSingleResult();
        return Optional.ofNullable(disco);
    }

    @Override
    public Disco save(Disco disco) {
        entityManager.persist(disco);
        return disco;
    }
}
