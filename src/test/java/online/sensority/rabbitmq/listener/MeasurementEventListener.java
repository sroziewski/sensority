package online.sensority.rabbitmq.listener;

import online.sensority.model.MeasurementMessage;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"test"})
public class MeasurementEventListener {

    MeasurementMessage measurementMessage;

    public void receiveMessage(MeasurementMessage message) {
        measurementMessage = message;
    }

    public MeasurementMessage getMessage(){
        return measurementMessage;
    }
}
