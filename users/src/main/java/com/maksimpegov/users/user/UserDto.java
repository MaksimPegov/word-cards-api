package com.maksimpegov.users.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "User's data transfer object (DTO)", description = "All necessary info about user")
public class UserDto {
    private String username;
    private String password;
}
