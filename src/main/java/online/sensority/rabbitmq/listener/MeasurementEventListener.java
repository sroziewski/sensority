package online.sensority.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import online.sensority.model.MeasurementMessage;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MeasurementEventListener {

    MeasurementMessage measurementMessage;

    public void receiveMessage(MeasurementMessage message) {
        log.info("Received <" + message + ">");
        measurementMessage = message;
        log.info("Message processed...");
    }

    public MeasurementMessage getMessage(){
        return measurementMessage;
    }
}
