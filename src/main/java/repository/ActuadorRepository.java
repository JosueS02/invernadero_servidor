package repository;

/**
 *
 * @author josue
 */
import model.entity.Actuador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuadorRepository extends JpaRepository<Actuador, Long> {
}
