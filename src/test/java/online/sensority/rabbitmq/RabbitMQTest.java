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
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectWriter;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
       List<MeasurementMessage> sendingMessage = createTestMessage();
       rabbitMQService.sendMessage(sendingMessage);
       Thread.sleep(1000);
       List<MeasurementMessage> messageReceived = measurementEventListener.getMessage();
       Assertions.assertEquals(sendingMessage, messageReceived);
    }

    private String createJsonTestMessage() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(createTestMessage());
    }

    private List<MeasurementMessage> createTestMessage() {
        return IntStream.range(0, 50)
                .boxed()
                .map(i -> MeasurementMessage.builder()
                        .temperature(101.2 + i)
                        .sensorId(String.valueOf(i))
                        .ip(String.format("10.10.10.%d", i))
                        .humidity(72.2 + i)
                        .pressure(1122.0 + i)
                        .voltage(0.5 + i)
                        .timestamp(new Timestamp(System.currentTimeMillis()))
                        .build())
                .collect(Collectors.toUnmodifiableList());
    }
}