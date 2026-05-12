package model.dto;

/**
 *
 * @author josue
 */
public class ComandoRequestDTO {

    private Long actuadorId;
    private String accion; 
    private Double valorParametro;
    private String origen;

    public ComandoRequestDTO() {
    }
    
    public Long getActuadorId() {
        return actuadorId;
    }

    public void setActuadorId(Long actuadorId) {
        this.actuadorId = actuadorId;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Double getValorParametro() {
        return valorParametro;
    }

    public void setValorParametro(Double valorParametro) {
        this.valorParametro = valorParametro;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
