package online.sensority.rabbitmq.listener;

import online.sensority.model.MeasurementMessage;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile({"test"})
public class MeasurementEventListener {

    List<MeasurementMessage> messageList;

    public void receiveMessage(List<MeasurementMessage> message) {
        messageList = message;
        message.forEach(System.out::println);
    }

    public List<MeasurementMessage> getMessage(){
        return messageList;
    }
}
