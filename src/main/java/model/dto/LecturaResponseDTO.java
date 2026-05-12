package model.dto;

/**
 *
 * @author josue
 */
import java.time.LocalDateTime;

public class LecturaResponseDTO {

    private Long sensorId;
    private String tipoSensor; 
    private Double valor;
    private String unidad; 
    private LocalDateTime timestamp;

    public LecturaResponseDTO() {
    }

    public LecturaResponseDTO(Long sensorId, String tipoSensor, Double valor, String unidad, LocalDateTime timestamp) {
        this.sensorId = sensorId;
        this.tipoSensor = tipoSensor;
        this.valor = valor;
        this.unidad = unidad;
        this.timestamp = timestamp;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public String getTipoSensor() {
        return tipoSensor;
    }

    public void setTipoSensor(String tipoSensor) {
        this.tipoSensor = tipoSensor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
