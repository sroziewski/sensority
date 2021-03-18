package online.sensority.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class RabbitMessage implements Serializable {
    private static final long serialVersionUID = -4981161628784858616L;

    private String routing_key;
    private String payload_encoding = "string";
    private Map<String, Integer> properties = Map.of("delivery_mode", 2);
    private List<MeasurementMessage> payload;

    public RabbitMessage(String routing_key, List<MeasurementMessage> payload) {
        this.routing_key = routing_key;
        this.payload = payload;
    }
}

