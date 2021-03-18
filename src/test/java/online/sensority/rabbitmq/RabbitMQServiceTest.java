package online.sensority.rabbitmq;

import online.sensority.rabbitmq.config.RabbitMqTestConfiguration;
import online.sensority.service.RabbitMQService;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@ContextConfiguration(classes = RabbitMqTestConfiguration.class)
public class RabbitMQServiceTest {

    private RabbitMQService rabbitMQService;

    public RabbitMQServiceTest(RabbitMQService rabbitMQService) {
        this.rabbitMQService = rabbitMQService;
    }

    @Test
    public void testSimplePutAndGet() {
        int i=1;
    }
}