package model.entity;

/**
 *
 * @author josue
 */
import jakarta.persistence.*;

@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ruta; 

    @OneToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @OneToOne
    @JoinColumn(name = "actuador_id")
    private Actuador actuador;

    public Topico() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Actuador getActuador() {
        return actuador;
    }

    public void setActuador(Actuador actuador) {
        this.actuador = actuador;
    }
    
    
}
