package com.jli.jlicommunications.controller;

import com.jli.jlicommunications.payloads.UserDto;
import com.jli.jlicommunications.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public UserDto addUser(@Payload UserDto userDto) {
        userService.saveUser(userDto);
        return userDto;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/topic")
    public UserDto disconnectUser(@Payload UserDto userDto) {
        userService.disconnectUser(userDto);
        return userDto;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
