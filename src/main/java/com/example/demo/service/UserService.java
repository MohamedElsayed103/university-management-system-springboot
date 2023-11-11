package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class UserService {
    private final UserRepository userRepository;

    public void signUp(){

    }
}
