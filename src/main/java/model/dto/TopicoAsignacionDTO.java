package model.dto;

/**
 *
 * @author josue
 */
public class TopicoAsignacionDTO {

    private String rutaMqtt;
    private Long dispositivoId;
    private String tipoDispositivo; 

    public TopicoAsignacionDTO() {
    }

    public String getRutaMqtt() {
        return rutaMqtt;
    }

    public void setRutaMqtt(String rutaMqtt) {
        this.rutaMqtt = rutaMqtt;
    }

    public Long getDispositivoId() {
        return dispositivoId;
    }

    public void setDispositivoId(Long dispositivoId) {
        this.dispositivoId = dispositivoId;
    }

    public String getTipoDispositivo() {
        return tipoDispositivo;
    }

    public void setTipoDispositivo(String tipoDispositivo) {
        this.tipoDispositivo = tipoDispositivo;
    }
}
