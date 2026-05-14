package controller;

/**
 *
 * @author josue
 */
import model.entity.Invernadero;
import service.InvernaderoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invernaderos") // 🟢 La ruta base para esta API
public class InvernaderoController {

    private final InvernaderoService invernaderoService;

    public InvernaderoController(InvernaderoService invernaderoService) {
        this.invernaderoService = invernaderoService;
    }

    // 1. Obtener todos los invernaderos (GET /api/invernaderos)
    @GetMapping
    public ResponseEntity<List<Invernadero>> listarTodos() {
        return ResponseEntity.ok(invernaderoService.obtenerTodos());
    }

    // 2. Obtener un invernadero específico (GET /api/invernaderos/1)
    @GetMapping("/{id}")
    public ResponseEntity<Invernadero> obtenerPorId(@PathVariable Long id) {
        return invernaderoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Crear un nuevo invernadero (POST /api/invernaderos)
    @PostMapping
    public ResponseEntity<Invernadero> crear(@RequestBody model.dto.CreateGreenhouseDTO request) {

        // Creamos la entidad vacía
        Invernadero invernadero = new Invernadero();

        // 🟢 Hacemos la traducción (Inglés -> Español)
        invernadero.setNombre(request.getName());
        invernadero.setUbicacion(request.getLocation());

        // Si no mandan estado, le ponemos ACTIVO por defecto
        if (request.getStatus() == null || request.getStatus().isEmpty()) {
            invernadero.setEstado("ACTIVO");
        } else {
            invernadero.setEstado(request.getStatus());
        }

        // Guardamos en PostgreSQL
        return ResponseEntity.ok(invernaderoService.guardar(invernadero));
    }

    // 4. Editar un invernadero (PUT /api/invernaderos/1)
    @PutMapping("/{id}")
    public ResponseEntity<Invernadero> actualizar(@PathVariable Long id, @RequestBody Invernadero detalles) {
        return invernaderoService.obtenerPorId(id).map(invernaderoExistente -> {
            invernaderoExistente.setNombre(detalles.getNombre());
            invernaderoExistente.setUbicacion(detalles.getUbicacion());
            invernaderoExistente.setEstado(detalles.getEstado());
            return ResponseEntity.ok(invernaderoService.guardar(invernaderoExistente));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. Eliminar un invernadero (DELETE /api/invernaderos/1)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (invernaderoService.obtenerPorId(id).isPresent()) {
            invernaderoService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
