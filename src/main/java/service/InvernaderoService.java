package service;

/**
 *
 * @author josue
 */
import model.entity.Invernadero;
import repository.InvernaderoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InvernaderoService {

    private final InvernaderoRepository invernaderoRepository;

    public InvernaderoService(InvernaderoRepository invernaderoRepository) {
        this.invernaderoRepository = invernaderoRepository;
    }

    public List<Invernadero> obtenerTodos() {
        return invernaderoRepository.findAll();
    }

    public Optional<Invernadero> obtenerPorId(Long id) {
        return invernaderoRepository.findById(id);
    }

    public Invernadero guardar(Invernadero invernadero) {
        return invernaderoRepository.save(invernadero);
    }

    public void eliminar(Long id) {
        invernaderoRepository.deleteById(id);
    }
}
