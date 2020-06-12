package com.example.mq.param;

import com.example.model.UserDto;

public class UserParam extends RequreParamBase {

    private UserDto userDto;

    public UserParam(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
