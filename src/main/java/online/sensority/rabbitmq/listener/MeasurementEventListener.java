package online.sensority.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import online.sensority.model.MeasurementMessage;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MeasurementEventListener {

    public void receiveMessage(List<MeasurementMessage> message) {
        message.forEach(System.out::println);
    }
}
