package model.dto;

import java.util.List;

/**
 *
 * @author josue
 */
public class CreateGreenhouseDTO {

    private String userId;
    private String name;
    private String location;
    private String status;
    private List<String> sensorIds;
    private List<String> actuatorIds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getSensorIds() {
        return sensorIds;
    }

    public void setSensorIds(List<String> sensorIds) {
        this.sensorIds = sensorIds;
    }

    public List<String> getActuatorIds() {
        return actuatorIds;
    }

    public void setActuatorIds(List<String> actuatorIds) {
        this.actuatorIds = actuatorIds;
    }

}
