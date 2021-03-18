package online.sensority.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeasurementMessage implements Serializable {
    private static final long serialVersionUID = -4981161628784858616L;

    private String sensorId;
    private String ip;
    private Double temperature;
    private Double pressure;
    private Double humidity;
    private Double voltage;
    private Timestamp timestamp;
}
