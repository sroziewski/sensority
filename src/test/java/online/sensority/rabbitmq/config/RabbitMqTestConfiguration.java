package online.sensority.rabbitmq.config;

import online.sensority.rabbitmq.listener.MeasurementEventListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;

import java.util.Collections;
import java.util.Set;

@TestConfiguration
@ActiveProfiles("test")
public class RabbitMqTestConfiguration {

    @Value("TEST")
    private String QUEUE_NAME;

    @Bean
    MeasurementEventListener listener(){
        return new MeasurementEventListener();
    }

//    @Container
//    GenericContainer rabbitMQContainer = new GenericContainer("rabbitmq:latest").withExposedPorts(5672);

    @Bean
    GenericContainer rabbitMQContainer(){
        RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:latest")
                .withExposedPorts(5672)
                .withQueue(QUEUE_NAME)
                .withExchange("direct-exchange", "direct")
                .withBinding("direct-exchange", QUEUE_NAME)
                .withUser("guest", "guest", Set.of("administrator"))
                .withPermission("/", "guest",  ".*", ".*", ".*")
        .waitingFor(Wait.defaultWaitStrategy());
        rabbitMQContainer.start();
        return rabbitMQContainer;
    }

//    @Bean
//    public Queue myQueue() {
//        return new Queue(QUEUE_NAME, false);
//    }

//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange("spring-boot-exchange");
//    }
//
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(QUEUE_NAME);
//    }

//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitFactory(SimpleRabbitListenerContainerFactoryConfigurer configurer, ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        configurer.configure(factory, connectionFactory);
//        factory.setMessageConverter(new Jackson2JsonMessageConverter());
//        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
//        factory.setConcurrentConsumers(3);
//        factory.setMaxConcurrentConsumers(10);
//
////            factory.setPrefetchCount(100);
//        return factory;
//    }

    @Bean
    CachingConnectionFactory connectionFactory(GenericContainer rabbitMQContainer) {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost", rabbitMQContainer.getMappedPort(5672));
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(MeasurementEventListener receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }


}
