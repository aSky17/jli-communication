package com.jli.jlicommunications.payloads;

import com.jli.jlicommunications.enitity.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String userName;
    private String fullName;
    private StatusDto status;

    public void setStatus(Status status) {
    }
}
