package controller;

/**
 *
 * @author josue
 */
import model.entity.Sensor;
import model.entity.Actuador;
import repository.SensorRepository;
import repository.ActuadorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dispositivos")
@CrossOrigin(origins = "*") 
public class DispositivoController {

    private final SensorRepository sensorRepository;
    private final ActuadorRepository actuadorRepository;

    public DispositivoController(SensorRepository sensorRepository, ActuadorRepository actuadorRepository) {
        this.sensorRepository = sensorRepository;
        this.actuadorRepository = actuadorRepository;
    }

    // GET: http://localhost:8080/api/dispositivos/sensores
    @GetMapping("/sensores")
    public ResponseEntity<List<Sensor>> obtenerSensores() {
        return new ResponseEntity<>(sensorRepository.findAll(), HttpStatus.OK);
    }

    // GET: http://localhost:8080/api/dispositivos/actuadores
    @GetMapping("/actuadores")
    public ResponseEntity<List<Actuador>> obtenerActuadores() {
        return new ResponseEntity<>(actuadorRepository.findAll(), HttpStatus.OK);
    }
}