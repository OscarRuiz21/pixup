package unam.diplomado.pixup.colonia.api;

import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;

import java.util.Collection;
import java.util.Optional;

public class ColoniaResource implements ColoniaApi {

    @Inject
    private ColoniaRepository coloniaRepository;

    @Override
    public Colonia getColoniaById(Integer id) {
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        return colonia.orElse(null);
        /*
        if (colonia.isPresent()) {
            return colonia.get();
        } else {
            return null;
        }
         */
    }

    @Override
    public Collection<Colonia> getColoniasByCp(String cp) {
        return coloniaRepository.findByCp(cp);
    }

}
