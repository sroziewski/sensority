package online.sensority.service;

import lombok.extern.slf4j.Slf4j;
import online.sensority.model.MeasurementEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RabbitMQService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${test.event.queue}")
    private String MESSAGE_QUEUE;

    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MeasurementEvent measurementEvent) {
        log.info("Sending message to queue: " + measurementEvent);
        rabbitTemplate.convertAndSend(MESSAGE_QUEUE, measurementEvent);
    }
}
