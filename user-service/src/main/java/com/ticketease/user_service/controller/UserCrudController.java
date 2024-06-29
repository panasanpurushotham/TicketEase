package com.ticketease.user_service.controller;


import com.ticketease.user_service.dto.request.UserRequestDto;
import com.ticketease.user_service.dto.response.UserResponseDto;
import com.ticketease.user_service.entity.User;
import com.ticketease.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserCrudController {

    @Autowired
    UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<Void> userCustomer(@RequestBody UserRequestDto requestDto){

        User user = userService.saveUser(requestDto);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserDetails(id));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticate(@RequestHeader(name = "email", required = false) String email, @RequestHeader(name = "password",required = false) String password) {
        return ResponseEntity.ok(userService.authenticate(email, password));
    }

}
