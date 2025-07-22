package unam.diplomado.pixup.disco.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.exceptions.ArtistaNotFoundException;
import unam.diplomado.pixup.disco.domain.exceptions.DiscoAlreadyExistsException;
import unam.diplomado.pixup.disco.domain.exceptions.DisqueraNotFoundException;
import unam.diplomado.pixup.disco.domain.exceptions.GeneroMusicalNotFoundException;
import unam.diplomado.pixup.disco.repository.ArtistaRepository;
import unam.diplomado.pixup.disco.repository.DiscoRepository;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;
import unam.diplomado.pixup.disco.repository.GeneroMusicalRepository;

@Stateless
public class DiscoServiceImpl implements DiscoService{

    @Inject
    private DisqueraRepository disqueraRepository;
    @Inject
    private ArtistaRepository artistaRepository;
    @Inject
    private GeneroMusicalRepository generoMusicalRepository;
    @Inject
    private DiscoRepository discoRepository;

    @Override
    @Transactional(value = Transactional.TxType.REQUIRED)
    public Disco registrarDisco(Disco disco) {

        if(discoRepository.findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId()).isPresent()){
            throw new DiscoAlreadyExistsException(
                    disco.getTitulo());
        }

        if(!disqueraRepository.findById(disco.getDisquera().getId()).isPresent()){
            throw new DisqueraNotFoundException(disco.getDisquera().getId());
        }
        if(!artistaRepository.findById(disco.getArtista().getId()).isPresent()){
            throw new ArtistaNotFoundException(disco.getArtista().getId());
        }
        if(!generoMusicalRepository.findById(disco.getGeneroMusical().getId()).isPresent()){
            throw new GeneroMusicalNotFoundException(disco.getGeneroMusical().getId());
        }
        System.out.println("artistaId: " + disco.getArtista().getId());
        System.out.println("disqueraId: " + disco.getDisquera().getId());
        System.out.println("generoMusicalId: " + disco.getGeneroMusical().getId());
        discoRepository.save(disco);

        return disco;
    }
}
