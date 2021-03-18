package online.sensority.event;

import online.sensority.model.RabbitMessage;
import org.springframework.context.ApplicationEvent;

public class MeasurementCreationEvent extends ApplicationEvent {

    public MeasurementCreationEvent(RabbitMessage rabbitMessage) {
        super(rabbitMessage);
    }
}
