package controller;

import java.time.LocalDateTime;
import java.util.Optional;
import model.dto.LoginRequestDTO;
import model.dto.RegisterRequestDTO;
import model.dto.UserApiResponseDTO;
import model.entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UsuarioRepository;
import security.JwtUtil;

/**
 *
 * @author josue
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository; // 🟢 Inyectamos la BD
    private final PasswordEncoder passwordEncoder;     // 🟢 Inyectamos el encriptador

    public UserController(JwtUtil jwtUtil, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody RegisterRequestDTO nuevoUsuario) {
        if (usuarioRepository.findByEmail(nuevoUsuario.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("{\"message\": \"El correo ya está registrado\"}");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(nuevoUsuario.getEmail());
        usuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));

        // 🟢 SOLUCIÓN: Llenamos los datos obligatorios automáticamente
        // Si el correo es "josue@gmail.com", el username será "josue"
        usuario.setUsername(nuevoUsuario.getEmail().split("@")[0]);

        // Le damos un rol por defecto para que Spring Security no falle después
        usuario.setRol("USER");

        // Ahora sí, PostgreSQL estará feliz porque no hay campos nulos
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        String token = jwtUtil.generarToken(usuarioGuardado.getEmail(), usuarioGuardado.getRol());

        return ResponseEntity.ok(new UserApiResponseDTO(
                usuarioGuardado.getId().toString(),
                usuarioGuardado.getEmail(),
                usuarioGuardado.getUsername(), // Usamos el username generado
                LocalDateTime.now().toString(),
                LocalDateTime.now().toString(),
                token
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO credentials) {
        // 1. Buscamos al usuario por su correo
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(credentials.getEmail());

        // 2. Verificamos si existe Y si la contraseña coincide con la encriptada
        if (usuarioOpt.isPresent() && passwordEncoder.matches(credentials.getPassword(), usuarioOpt.get().getPassword())) {

            Usuario usuario = usuarioOpt.get(); // Extraemos el usuario de la BD

            // 3. Generamos su token usando su rol real de la base de datos
            String token = jwtUtil.generarToken(usuario.getEmail(), usuario.getRol());

            // 4. Devolvemos los datos al frontend (React)
            return ResponseEntity.ok(new UserApiResponseDTO(
                    usuario.getId().toString(),
                    usuario.getEmail(),
                    usuario.getUsername(), // Mandamos el username que autogeneramos en el registro
                    LocalDateTime.now().toString(),
                    LocalDateTime.now().toString(),
                    token
            ));
        }

        // Si el correo no existe o la contraseña está mal, devolvemos error 401
        return ResponseEntity.status(401).body("{\"message\": \"Correo o contraseña incorrectos\"}");
    }
}
