package com.jli.jlicommunications.enitity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class User {
    @Id
    private String userName;
    private String fullName;
    private Status status;
}
