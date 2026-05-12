package repository;

/**
 *
 * @author josue
 */
import model.entity.Invernadero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvernaderoRepository extends JpaRepository<Invernadero, Long> {
}
