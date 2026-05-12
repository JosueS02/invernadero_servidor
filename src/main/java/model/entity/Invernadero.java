package model.entity;

/**
 *
 * @author josue
 */
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "invernaderos")
public class Invernadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "ubicacion", length = 200)
    private String ubicacion;

    @Column(name = "estado_activo")
    private boolean estadoActivo = true;

    @OneToMany(mappedBy = "invernadero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Sensor> sensores;

    @OneToMany(mappedBy = "invernadero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Actuador> actuadores;

    public Invernadero() {
    }

    public Invernadero(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estadoActivo = true;
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

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public void setEstadoActivo(boolean estadoActivo) {
        this.estadoActivo = estadoActivo;
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
}