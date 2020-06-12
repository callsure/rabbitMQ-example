package com.example.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * 发送的通道类型
 */
public interface RequireSender {

    @Output(RequireConst.simpleConst)
    MessageChannel output_1();

    @Output(RequireConst.delayConstOutput)
    MessageChannel output_2();

    @Output(RequireConst.ackConstOutput)
    MessageChannel output_3();

}
