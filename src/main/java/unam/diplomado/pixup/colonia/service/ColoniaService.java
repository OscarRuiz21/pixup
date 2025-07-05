package unam.diplomado.pixup.colonia.service;

import jakarta.ejb.Local;
import unam.diplomado.pixup.colonia.domain.Colonia;

@Local
public interface ColoniaService {

    Colonia obtenerColoniaPorId(Integer id);
    Colonia crearColonia(Colonia colonia);
    Colonia actualizarColonia(Colonia colonia);
    void eliminarColoniaPorId(Integer id);

}
