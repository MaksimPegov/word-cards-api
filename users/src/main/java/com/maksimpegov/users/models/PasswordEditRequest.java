package com.maksimpegov.users.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordEditRequest {
    private String username;
    private String oldPassword;
    private String newPassword;
}
