package com.maksimpegov.users.models;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Password edit request",description = "Request form for password edit")
public class PasswordEditRequest {
    private String username;
    private String oldPassword;
    private String newPassword;
}
