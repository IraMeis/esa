package net.morena.esa.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitConfig {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue.mail}")
    private String queueMailName;
    @Value("${rabbitmq.routing.key.mail}")
    private String routingKeyMail;

    @Value("${rabbitmq.queue.log}")
    private String queueLogName;
    @Value("${rabbitmq.routing.key.log}")
    private String routingKeyLog;

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue queueMail(){
        return new Queue(queueMailName);
    }

    @Bean
    public Queue queueLog(){
        return new Queue(queueLogName);
    }

    @Bean
    public Binding bindingMail(@Qualifier("queueMail") Queue queue, TopicExchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(routingKeyMail);
    }

    @Bean
    public Binding bindingLog(@Qualifier("queueLog") Queue queue, TopicExchange exchange){
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(routingKeyLog);
    }

}