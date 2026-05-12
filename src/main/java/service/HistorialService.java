package service;

/**
 *
 * @author josue
 */
import model.entity.Lectura;
import model.entity.Sensor;
import repository.LecturaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistorialService {

    private final LecturaRepository lecturaRepository;

    public HistorialService(LecturaRepository lecturaRepository) {
        this.lecturaRepository = lecturaRepository;
    }

    @Transactional
    public Lectura registrarLectura(Sensor sensor, Double valor) {
        Lectura nuevaLectura = new Lectura(valor, sensor);
        return lecturaRepository.save(nuevaLectura);
    }
}
