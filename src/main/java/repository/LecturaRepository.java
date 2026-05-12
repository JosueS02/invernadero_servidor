package repository;

/**
 *
 * @author josue
 */
import model.entity.Lectura;
import model.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository

public interface LecturaRepository extends JpaRepository<Lectura, Long> {

    List<Lectura> findTop10BySensorOrderByFechaHoraDesc(Sensor sensor);
}
