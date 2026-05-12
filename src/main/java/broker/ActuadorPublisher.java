package broker;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 *
 * @author josue
 */
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface ActuadorPublisher {
    
    void enviarComando(@Header(MqttHeaders.TOPIC) String topico, String payload);
    
}
