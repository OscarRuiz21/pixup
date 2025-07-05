package unam.diplomado.pixup.colonia.repository;

import unam.diplomado.pixup.colonia.domain.Municipio;

import java.util.Optional;

public interface MunicipioRepository {

    Optional<Municipio> findById(Integer id);

}
