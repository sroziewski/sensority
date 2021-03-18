package online.sensority.service;

import lombok.extern.slf4j.Slf4j;
import online.sensority.model.MeasurementMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Service
public class RabbitMQService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${measurement.queue}")
    private String MESSAGE_QUEUE;

    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(List<MeasurementMessage> messageList) {
        log.info("Sending message to queue: " + messageList);
        rabbitTemplate.convertAndSend(MESSAGE_QUEUE, messageList);
    }
}
