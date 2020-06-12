package com.example.mq;

import com.example.mq.param.RequreParamBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

import javax.annotation.PostConstruct;

@Slf4j
@EnableBinding(RequireSender.class)
public class ListenerMgr {

    @Autowired
    private RequireSender sender;

    @PostConstruct
    public void init() {
        instance = this;
    }

    private static ListenerMgr instance = null;

    public static ListenerMgr getInstance() {
        return instance;
    }

    /**
     * 推送
     * @param require
     * @param param
     * @param <T>
     */
    public <T extends RequreParamBase> void notify(RequireType<T> require, T param) {
        if (null == sender || !require.getOutput().apply(sender).send(MessageBuilder.withPayload(param).build(), 200)) {
            log.error("消息通知没有发送出去：" + param);
        }
    }

    /**
     * 延迟推送
     * @param require
     * @param param
     * @param <T>
     */
    public <T extends RequreParamBase> void notify(RequireType<T> require, T param, long delay) {
        if (null == sender || !require.getOutput().apply(sender).send(MessageBuilder.withPayload(param).setHeader("x-delay", delay).build(), 200)) {
            log.error("消息通知没有发送出去：" + param);
        }
    }

}
