package com.example.listener;

import com.example.model.UserDto;
import com.example.mq.RequireConst;
import com.example.mq.RequireReceiver;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;

@Slf4j
@EnableBinding(RequireReceiver.class)
public class TestListener {

    @StreamListener(RequireConst.simpleConst)
    public void handle(UserDto userDto) {
        log.info("接收简单模式的消息:");
        log.info(userDto.toString());
    }

    @StreamListener(RequireConst.delayConstInput)
    public void handleDelay(UserDto userDto) {
        log.info("接收延迟模式的消息:");
        log.info(userDto.toString());
    }

    @StreamListener(RequireConst.ackConstInput)
    public void handle3(UserDto userDto, @Header(AmqpHeaders.CHANNEL) Channel channel,
                        @Header(AmqpHeaders.DELIVERY_TAG) Long deliveryTag) {
        log.info("确认模式:");
        log.info(userDto.toString());
        try {
            channel.basicAck(deliveryTag, false);//手动确认
        } catch (Exception ex) {
            //记录日志
        }
    }
}
