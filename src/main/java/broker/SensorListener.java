package broker;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 *
 * @author josue
 */
@Component
public class SensorListener {

    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void manejarMensajeEntrante(Message<String> mensaje) {
        MessageHeaders headers = mensaje.getHeaders();
        String topico = headers.get("mqtt_receivedTopic").toString();
        String payload = mensaje.getPayload();

        System.out.println("\n=========================================");
        System.out.println("📩 NUEVA LECTURA DESDE EL INVERNADERO");
        System.out.println("Tópico  : " + topico);
        System.out.println("Mensaje : " + payload);
        System.out.println("=========================================\n");

        // TODO: En el siguiente sprint, aquí inyectaremos el "SimulacionService" 
        // para guardar este JSON en la base de datos y revisar si la temperatura es muy alta.
    }
}
