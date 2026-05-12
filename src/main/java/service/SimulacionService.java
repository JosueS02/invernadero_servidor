package service;

/**
 *
 * @author josue
 */
import model.entity.Sensor;
import org.springframework.stereotype.Service;

@Service
public class SimulacionService {

    private final HistorialService historialService;
    private final EvaluadorUmbrales evaluadorUmbrales;

    public SimulacionService(HistorialService historialService, EvaluadorUmbrales evaluadorUmbrales) {
        this.historialService = historialService;
        this.evaluadorUmbrales = evaluadorUmbrales;
    }

    public void procesarNuevaLectura(Sensor sensor, Double valor) {
        historialService.registrarLectura(sensor, valor);

        if (sensor.getTipo().equalsIgnoreCase("TEMPERATURA")) {
            if (evaluadorUmbrales.requiereEnfriamiento(valor)) {
                ejecutarAccionAutomatica(sensor.getInvernadero().getId(), "VENTILADOR", "ENCENDER");
            }
        } else if (sensor.getTipo().equalsIgnoreCase("HUMEDAD")) {
            if (evaluadorUmbrales.requiereRiego(valor)) {
                ejecutarAccionAutomatica(sensor.getInvernadero().getId(), "RIEGO", "ENCENDER");
            }
        }
        
    }

    private void ejecutarAccionAutomatica(Long invernaderoId, String tipoActuador, String accion) {
         System.out.println("AUTOMATIZACIÓN: Enviando comando [" + accion + "] al actuador tipo [" + tipoActuador + "] del invernadero " + invernaderoId);
    }
}
