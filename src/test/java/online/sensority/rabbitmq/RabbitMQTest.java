package online.sensority.rabbitmq;

import online.sensority.service.RabbitMQService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    RabbitMQService rabbitMQService;

    @Value("${measurement.queue}")
    String QUEUE_NAME;

   @Test
    public void testSimplePutAndGet() {
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(RabbitMqTestConfiguration.class);
//        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
//        amqpTemplate.convertAndSend("Hello World");
        int i=1;
    }
}