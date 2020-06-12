package com.example.mq;

import org.springframework.messaging.MessageChannel;

import java.util.function.Function;

public class RequireTypeBase {

    private final String requireName;

    private final Function<RequireSender, MessageChannel> output;


    public RequireTypeBase(String requireName, Function<RequireSender, MessageChannel> output) {
        this.requireName = requireName;
        this.output = output;
    }

    public String getRequireName() {
        return requireName;
    }

    public Function<RequireSender, MessageChannel> getOutput() {
        return output;
    }
}
