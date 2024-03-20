package com.maksimpegov.users.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User additional information", description = "All other info about user, that are not included in user's DTO")
public class UserInfo {
    private String username;
    private String created_at;
}
