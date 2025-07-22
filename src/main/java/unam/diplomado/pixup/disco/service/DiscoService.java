package unam.diplomado.pixup.disco.service;

import unam.diplomado.pixup.disco.domain.Disco;
import unam.diplomado.pixup.disco.repository.DisqueraRepository;

public interface DiscoService {
    Disco registrarDisco(Disco disco);
}
