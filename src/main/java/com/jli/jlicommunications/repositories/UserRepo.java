package com.jli.jlicommunications.repositories;

import com.jli.jlicommunications.enitity.Status;
import com.jli.jlicommunications.enitity.User;
import com.jli.jlicommunications.payloads.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepo extends MongoRepository<User,String> {
    List<UserDto> findAllByStatus(Status status);
}
