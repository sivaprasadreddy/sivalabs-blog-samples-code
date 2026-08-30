package com.sivalabs.sringboot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tools.jackson.databind.json.JsonMapper;

@Service
public class OrderMessageSender {
    private final RabbitTemplate rabbitTemplate;
    private final JsonMapper jsonMapper;

    @Autowired
    public OrderMessageSender(RabbitTemplate rabbitTemplate, JsonMapper jsonMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.jsonMapper = jsonMapper;
    }

    public void sendOrder(Order order) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, order);

        /*
        String orderJson = jsonMapper.writeValueAsString(order);
        Message message = MessageBuilder
                            .withBody(orderJson.getBytes())
                            .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                            .build();
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_ORDERS, message);
        */
    }
}
