package unam.diplomado.pixup.colonia.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.domain.ColoniaNotFoundException;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;

import java.util.Optional;

@Stateless
public class ColoniaServiceImpl implements ColoniaService {

    @Inject
    private ColoniaRepository coloniaRepository;

    @Override
    public Colonia obtenerColoniaPorId(Integer id) {
        Optional<Colonia> colonia = coloniaRepository.findById(id);
        if (colonia.isPresent()) {
            return colonia.get();
        }
        throw new ColoniaNotFoundException(id);
    }

    @Override
    public Colonia crearColonia(Colonia colonia) {
        return null;
    }

    @Override
    public Colonia actualizarColonia(Colonia colonia) {
        return null;
    }

    @Override
    public void eliminarColoniaPorId(Integer id) {

    }
}
