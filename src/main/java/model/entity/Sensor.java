package model.entity;

/**
 *
 * @author josue
 */
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sensores")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String tipo; 

    @Column(name = "unidad_medida")
    private String unidadMedida; 

    @ManyToOne
    @JoinColumn(name = "invernadero_id", nullable = false)
    private Invernadero invernadero;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL)
    private List<Lectura> lecturas;

    @OneToOne(mappedBy = "sensor")
    private Topico topico;

    public Sensor() {}

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Invernadero getInvernadero() {
        return invernadero;
    }

    public void setInvernadero(Invernadero invernadero) {
        this.invernadero = invernadero;
    }

    public List<Lectura> getLecturas() {
        return lecturas;
    }

    public void setLecturas(List<Lectura> lecturas) {
        this.lecturas = lecturas;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }
    
    
}