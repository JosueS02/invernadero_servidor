package service;

/**
 *
 * @author josue
 */
import org.springframework.stereotype.Component;

@Component
public class EvaluadorUmbrales {

    private static final double MAX_TEMP = 30.0;
    private static final double MIN_HUMEDAD = 40.0;

    public boolean requiereEnfriamiento(Double temperaturaActual) {
        return temperaturaActual > MAX_TEMP;
    }

    public boolean requiereRiego(Double humedadActual) {
        return humedadActual < MIN_HUMEDAD;
    }
}