package com.example.controller;

import com.example.model.UserDto;
import com.example.mq.ListenerMgr;
import com.example.mq.RequireType;
import com.example.mq.param.UserParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("rabbitmq")
public class ProviderController {

    @RequestMapping("provider")
    public String provider() {
        UserDto userDto = new UserDto();
//        userDto.setId(String.valueOf(UUID.randomUUID()));
        userDto.setName("简单模式");
        userDto.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ListenerMgr.getInstance().notify(RequireType.REQUIRE_SIMPLE, new UserParam(userDto));

        UserDto userDto_1 = new UserDto();
        userDto_1.setName("延迟模式");
        userDto_1.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ListenerMgr.getInstance().notify(RequireType.REQUIRE_DELAY, new UserParam(userDto_1), 5000);

        UserDto userDto_2 = new UserDto();
        userDto_2.setName("确认模式");
        userDto_2.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        ListenerMgr.getInstance().notify(RequireType.REQUIRE_ACK, new UserParam(userDto_2));
        return "ok";
    }

}
