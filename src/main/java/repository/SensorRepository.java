package repository;

/**
 *
 * @author josue
 */
import model.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository

public interface SensorRepository extends JpaRepository<Sensor, Long> {

    List<Sensor> findByTipo(String tipo);
}
