package online.sensority.rabbitmq;

import online.sensority.model.MeasurementMessage;
import online.sensority.rabbitmq.listener.MeasurementEventListener;
import online.sensority.service.RabbitMQService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.UUID;

@ActiveProfiles("test")
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    RabbitMQService rabbitMQService;

    @Autowired
    MeasurementEventListener measurementEventListener;

    @Value("${measurement.queue}")
    String QUEUE_NAME;

   @Test
    public void testSimplePutAndGet() throws InterruptedException {
       MeasurementMessage testMessage = new MeasurementMessage(UUID.randomUUID().toString(), "Big Thing", new Date());
       rabbitMQService.sendMessage(testMessage);
       Thread.sleep(1000);
       MeasurementMessage messageReceived = measurementEventListener.getMessage();
       Assertions.assertEquals(testMessage.getMovieId(), messageReceived.getMovieId());
    }
}