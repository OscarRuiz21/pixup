package unam.diplomado.pixup.disco.repository.implementations;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import unam.diplomado.pixup.disco.domain.Artista;
import unam.diplomado.pixup.disco.repository.ArtistaRepository;

import java.util.Optional;

@Singleton
public class JpaArtistaRepository implements ArtistaRepository {
    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public Optional<Artista> findById(Integer id) {
        Artista artista = entityManager.find(Artista.class, id);
        return Optional.ofNullable(artista);
    }
}
