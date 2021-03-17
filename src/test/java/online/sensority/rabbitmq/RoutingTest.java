package online.sensority.rabbitmq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ContextConfiguration(classes = RabbitMqTestConfiguration.class)
public class RoutingTest {

    private RabbitMQContainer underTest;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // container {
    @Container
    public RabbitMQContainer rabbitmq = new RabbitMQContainer(DockerImageName.parse("rabbitmq"))
            .withExposedPorts(5672);
    // }


    @BeforeEach
    public void setUp() {
        String address = rabbitmq.getHost();
        Integer port = rabbitmq.getFirstMappedPort();


    }

    @Test
    public void testSimplePutAndGet() {
        int i=1;
    }
}