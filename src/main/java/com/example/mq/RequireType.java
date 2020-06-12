package com.example.mq;

import com.example.mq.param.RequreParamBase;
import com.example.mq.param.UserParam;
import org.springframework.messaging.MessageChannel;

import java.util.function.Function;

/**
 * mq 类型
 * 多个应用注意注意开启消费组，防止多个应用同时消费一个消息
 * @param <T>
 */
public class RequireType<T extends RequreParamBase> extends RequireTypeBase {

    /**
     * 简单模式
     */
    public static RequireType<UserParam> REQUIRE_SIMPLE = new RequireType<>("简单模式", RequireSender::output_1);

    /**
     * 延迟模式
     * 需要在配置application.yml启动延迟模式
     */
    public static RequireType<UserParam> REQUIRE_DELAY = new RequireType<>("延迟模式", RequireSender::output_2);

    /**
     * 确认模式
     * 需要在配置application.yml启动手动模式
     */
    public static RequireType<UserParam> REQUIRE_ACK = new RequireType<>("确认模式", RequireSender::output_3);

    public RequireType(String requireName, Function<RequireSender, MessageChannel> output) {
        super(requireName, output);
    }
}
