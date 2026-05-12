package model.entity;

/**
 *
 * @author josue
 */
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lecturas")
public class Lectura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double valor;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    // RELACIÓN: Muchas lecturas pertenecen a UN solo sensor
    @ManyToOne
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;

    public Lectura() {
        this.fechaHora = LocalDateTime.now();
    }

    public Lectura(Double valor, Sensor sensor) {
        this.valor = valor;
        this.sensor = sensor;
        this.fechaHora = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
 
    
}
