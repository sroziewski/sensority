package online.sensority.rabbitmq.listener;

import online.sensority.model.MeasurementMessage;
import online.sensority.model.RabbitMessage;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"test"})
public class MeasurementEventListener {

    RabbitMessage messageList;

    public void receiveMessage(RabbitMessage message) {
        messageList = message;
        message.getPayload().forEach(System.out::println);
    }

    public RabbitMessage getMessage(){
        return messageList;
    }
}
