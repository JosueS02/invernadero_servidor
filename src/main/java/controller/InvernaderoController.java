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
@RequestMapping("/api/invernaderos")
@CrossOrigin(origins = "*")
public class InvernaderoController {

    private final InvernaderoService invernaderoService;

    public InvernaderoController(InvernaderoService invernaderoService) {
        this.invernaderoService = invernaderoService;
    }

    @GetMapping
    public ResponseEntity<List<Invernadero>> obtenerInvernaderos() {
        List<Invernadero> lista = invernaderoService.obtenerTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Invernadero> crearInvernadero(@RequestBody Invernadero nuevoInvernadero) {
        Invernadero creado = invernaderoService.crearInvernadero(nuevoInvernadero);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }
}
