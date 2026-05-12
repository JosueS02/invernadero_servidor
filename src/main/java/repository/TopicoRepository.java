package repository;

/**
 *
 * @author josue
 */
import model.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Busca el tópico por su ruta (ej: "invernadero/1/temp")
    Optional<Topico> findByRuta(String ruta);
}
