package unam.diplomado.pixup.disco.service;

import jakarta.inject.Inject;
import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.domain.exceptions.ArtistaNotFoundException;
import unam.diplomado.pixup.disco.domain.exceptions.DiscoAlreadyExistsException;
import unam.diplomado.pixup.disco.domain.exceptions.DisqueraNotFoundException;
import unam.diplomado.pixup.disco.domain.exceptions.GeneroMusicalNotFoundException;
import unam.diplomado.pixup.disco.repository.ArtistaRepository;
import unam.diplomado.pixup.disco.repository.DiscoRepository;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;
import unam.diplomado.pixup.disco.repository.GeneroMusicalRepository;

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
    public Disco registrarDisco(Disco disco) {

        if(!disqueraRepository.findById(disco.getDisquera().getId()).isPresent()){
            throw new DisqueraNotFoundException(disco.getDisquera().getId());
        }
        if(!artistaRepository.findById(disco.getArtista().getId()).isPresent()){
            throw new ArtistaNotFoundException(disco.getArtista().getId());
        }
        if(!generoMusicalRepository.findById(disco.getGeneroMusical().getId()).isPresent()){
            throw new GeneroMusicalNotFoundException(disco.getGeneroMusical().getId());
        }

        if(discoRepository.findByTituloAndArtista(disco.getTitulo(), disco.getArtista().getId()).isPresent()){
            throw new DiscoAlreadyExistsException(
                    disco.getTitulo());
        }

        Disco discoSaved= discoRepository.save(disco);
        return discoSaved;
    }
}
