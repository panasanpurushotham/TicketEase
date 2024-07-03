package com.ticketease.user_service.service.impl;


import com.ticketease.user_service.dto.request.UserRequestDto;
import com.ticketease.user_service.dto.response.UserResponseDto;
import com.ticketease.user_service.entity.User;
import com.ticketease.user_service.mapper.DtoToEntityMapper;
import com.ticketease.user_service.repository.UserRepository;
import com.ticketease.user_service.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DtoToEntityMapper mapper;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public User saveUser(UserRequestDto dto) {
        User user = mapper.mapToEntity(dto, User.class);
        return userRepository.save(user);
    }

    @Override
    public UserResponseDto getUserDetails(Long id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.mapToEntity(user, UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream()
                .map(user -> {
                    UserResponseDto dto = new UserResponseDto();
                    dto.setId(user.getId());
                    dto.setUserName(user.getUsername());
                    dto.setEmail(user.getEmail());
                    dto.setPassword(user.getPassword());
                    dto.setRole(user.getRole());
                    return dto;
                })
                .collect(Collectors.toList());

    }
    @Override
    public User getEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User authenticate(String email, String password) throws Exception {
        User user = userRepository.findByEmail(email);
        if (user.getPassword().equals(password)) {
            return user;
        }else {
            throw new Exception("Credentials are invalid");
        }
    }

}
