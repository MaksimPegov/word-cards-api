package com.maksimpegov.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public record UsersController(UsersService usersService) {

    @GetMapping
    public ResponseEntity<String> status(){
        return ResponseEntity.ok(usersService.status());
    }
}
