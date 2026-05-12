package websocket;

import model.dto.LecturaResponseDTO;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 *
 * @author josue
 */
@Controller
public class TelemetriaController {

    private final SimpMessagingTemplate messagingTemplate;

    public TelemetriaController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void enviarTelemetriaFrontend(LecturaResponseDTO lectura) {
        messagingTemplate.convertAndSend("/topic/sensores", lectura);
    }
}
