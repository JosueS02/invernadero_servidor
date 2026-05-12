package controller;

import java.time.LocalDateTime;
import model.dto.LoginRequestDTO;
import model.dto.RegisterRequestDTO;
import model.dto.UserApiResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.JwtUtil;

/**
 *
 * @author josue
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final JwtUtil jwtUtil;

    public UserController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    
    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody RegisterRequestDTO nuevoUsuario) {
        // Generamos un token para el nuevo usuario
        String token = jwtUtil.generarToken(nuevoUsuario.getEmail(), "ADMIN");
        
        // Devolvemos el mismo formato JSON que React espera
        UserApiResponseDTO respuesta = new UserApiResponseDTO(
            "1", // ID simulado
            nuevoUsuario.getEmail(),
            nuevoUsuario.getFullName(),
            LocalDateTime.now().toString(),
            LocalDateTime.now().toString(),
            token
        );
        
        return ResponseEntity.ok(respuesta);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO credentials) {
        if (credentials.getEmail() != null && !credentials.getEmail().isEmpty()) {

            String token = jwtUtil.generarToken(credentials.getEmail(), "ADMIN");

            UserApiResponseDTO respuesta = new UserApiResponseDTO(
                    "1", // ID simulado
                    credentials.getEmail(),
                    "Usuario Simulado", // FullName simulado
                    LocalDateTime.now().toString(),
                    LocalDateTime.now().toString(),
                    token
            );

            return ResponseEntity.ok(respuesta);
        }
        return ResponseEntity.status(401).body("{\"message\": \"Credenciales inválidas\"}");
    }
}
