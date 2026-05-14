package model.entity;

/**
 *
 * @author josue
 */
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "invernaderos")
public class Invernadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 200)
    private String ubicacion;

    @Column(nullable = false)
    private String estado = "ACTIVO"; // Puede ser ACTIVO, INACTIVO, MANTENIMIENTO

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @OneToMany(mappedBy = "invernadero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sensor> sensores;

    @OneToMany(mappedBy = "invernadero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Actuador> actuadores;

    public Invernadero() {
    }

    public Invernadero(Long id, String nombre, String ubicacion, List<Sensor> sensores, List<Actuador> actuadores) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.sensores = sensores;
        this.actuadores = actuadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public List<Actuador> getActuadores() {
        return actuadores;
    }

    public void setActuadores(List<Actuador> actuadores) {
        this.actuadores = actuadores;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}