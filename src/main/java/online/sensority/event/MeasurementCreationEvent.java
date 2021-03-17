package online.sensority.event;

import online.sensority.model.Measurement;
import org.springframework.context.ApplicationEvent;

public class MeasurementCreationEvent extends ApplicationEvent {

    public MeasurementCreationEvent(Measurement measurement) {
        super(measurement);
    }
}
