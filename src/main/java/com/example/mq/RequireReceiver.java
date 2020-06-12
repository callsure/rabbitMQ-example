package com.example.mq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * 接收的通道类型
 */
public interface RequireReceiver {

    @Input(RequireConst.simpleConst)
    SubscribableChannel input_1();

    @Input(RequireConst.delayConstInput)
    SubscribableChannel input_2();

    @Input(RequireConst.ackConstInput)
    SubscribableChannel input_3();

}
