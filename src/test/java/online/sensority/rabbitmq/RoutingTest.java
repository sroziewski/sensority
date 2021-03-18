package online.sensority.rabbitmq;

import online.sensority.rabbitmq.config.RabbitConfiguration;
import online.sensority.rabbitmq.config.RabbitMqTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.Testcontainers;
import org.testcontainers.containers.Container;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;
import org.testcontainers.shaded.com.google.common.collect.ImmutableSet;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@Testcontainers
//@ContextConfiguration(classes = RabbitMqTestConfiguration.class)
@Import(RabbitConfiguration.class)
@ActiveProfiles("test")
public class RoutingTest {

    private RabbitTemplate rabbitTemplate;


    GenericContainer rabbitMQContainer = new GenericContainer("rabbitmq:latest")
            .withExposedPorts(5672);
//            .waitingFor(Wait.forHealthcheck());

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("QUEUE_NAME");
    }


    @BeforeEach
    public void setUp() throws IOException, InterruptedException {
        rabbitMQContainer.start();
//        Http2SolrClient
//        new RabbitTemplate();
//        rabbitMQContainer.con()
        String address = rabbitMQContainer.getHost();
        Integer port = rabbitMQContainer.getFirstMappedPort();
        List<String> portBindings = rabbitMQContainer.getPortBindings();
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        int i = 1;

    }

    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost", rabbitMQContainer.getMappedPort(5672));
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Test
    public void testSimplePutAndGet() {
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(RabbitConfiguration.class);
//        AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
//        amqpTemplate.convertAndSend("Hello World");
        int i=1;
    }
}