package com.ticketease.user_service.service;


import com.ticketease.user_service.dto.request.UserRequestDto;
import com.ticketease.user_service.dto.response.UserResponseDto;
import com.ticketease.user_service.entity.User;

public interface UserService {


    User saveUser(UserRequestDto dto);


    UserResponseDto getUserDetails(Long id);

    User authenticate(String email, String password);

}
