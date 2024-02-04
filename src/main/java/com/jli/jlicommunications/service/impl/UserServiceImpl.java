package com.jli.jlicommunications.service.impl;

import com.jli.jlicommunications.enitity.User;
import com.jli.jlicommunications.enitity.Status;
import com.jli.jlicommunications.payloads.UserDto;
import com.jli.jlicommunications.repositories.UserRepo;
import com.jli.jlicommunications.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    public void saveUser(UserDto userDto) {
        userDto.setStatus(Status.ONLINE);
        userRepo.save(userDtoToUser(userDto));
    }

    @Override
    public void disconnectUser(UserDto userDto) {
        var storedUser = userRepo.findById(userDto.getUserName())
                .orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            userRepo.save(storedUser);
        }
    }

    @Override
    public List<UserDto> findConnectedUsers() {
        return userRepo.findAllByStatus(Status.ONLINE);
    }

    public User userDtoToUser(UserDto userDto) {
        return this.modelMapper.map(userDto, User.class);
    }

    public UserDto userDtoToUser(User user) {
        return this.modelMapper.map(user,UserDto.class);
    }

}
