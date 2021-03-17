package online.sensority.rabbitmq;

import online.sensority.rabbitmq.listener.MeasurementEventListener;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class RabbitMqTestConfiguration {
    @Value("${test.event.queue}")
    private String QUEUE_NAME;

    @Bean
    public Queue myQueue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-exchange");
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(QUEUE_NAME);
    }

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
