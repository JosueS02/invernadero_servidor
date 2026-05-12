package controller;

/**
 *
 * @author josue
 */
import model.entity.Topico;
import repository.TopicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
@CrossOrigin(origins = "*")
public class TopicoController {

    private final TopicoRepository topicoRepository;

    public TopicoController(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    // GET: http://localhost:8080/api/topicos
    @GetMapping
    public ResponseEntity<List<Topico>> obtenerTopicos() {
        return new ResponseEntity<>(topicoRepository.findAll(), HttpStatus.OK);
    }

    // POST: http://localhost:8080/api/topicos
    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody Topico nuevoTopico) {
        Topico guardado = topicoRepository.save(nuevoTopico);
        return new ResponseEntity<>(guardado, HttpStatus.CREATED);
    }
}
