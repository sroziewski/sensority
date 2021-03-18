package online.sensority.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Measurement {
    private String sensorId;
    private String ip;
    private Double temperature;
    private Double pressure;
    private Double humidity;
    private Double voltage;
    private Timestamp timestamp;
}
