package com.deusto.google_server.service;

import com.deusto.google_server.entity.User;
import com.deusto.google_server.dto.GoogleAuthRequestDTO;
import com.deusto.google_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoogleAuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(GoogleAuthRequestDTO request) {
        // Buscar al usuario por email
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(request.getPassword())) {
                return true; // Usuario autenticado
            } else {
                throw new IllegalArgumentException("Invalid password!");
            }
        } else {
            throw new IllegalArgumentException("User not found!");
        }
    }


    // Registrar un nuevo usuario
    public String register(User user) {
        userRepository.save(user);
        return "User registered successfully: " + user.getEmail();
    }
}
