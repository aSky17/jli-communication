package com.jli.jlicommunications.service;

import com.jli.jlicommunications.payloads.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    void disconnectUser(UserDto userDto);

    List<UserDto> findConnectedUsers();
}
