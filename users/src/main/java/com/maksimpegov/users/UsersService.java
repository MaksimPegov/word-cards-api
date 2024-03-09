package com.maksimpegov.users;

import org.springframework.stereotype.Service;

@Service
public record UsersService() {
    public String status(){
        return "All is up and running!";
    }
}
