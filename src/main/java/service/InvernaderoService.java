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

@Service
public class InvernaderoService {

    private final InvernaderoRepository invernaderoRepository;

    public InvernaderoService(InvernaderoRepository invernaderoRepository) {
        this.invernaderoRepository = invernaderoRepository;
    }

    @Transactional(readOnly = true)
    public List<Invernadero> obtenerTodos() {
        return invernaderoRepository.findAll();
    }

    @Transactional
    public Invernadero crearInvernadero(Invernadero invernadero) {
        return invernaderoRepository.save(invernadero);
    }
}
