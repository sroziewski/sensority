package online.sensority.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import online.sensority.model.MeasurementEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MeasurementEventListener {
    public void receiveMessage(MeasurementEvent message) {
        log.info("Received <" + message + ">");
        log.info("Message processed...");
    }
}
