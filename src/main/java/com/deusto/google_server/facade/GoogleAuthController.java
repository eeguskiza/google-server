package com.deusto.google_server.facade;

import com.deusto.google_server.dto.GoogleAuthRequestDTO;
import com.deusto.google_server.entity.User;
import com.deusto.google_server.service.GoogleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/google")
public class GoogleAuthController {

    @Autowired
    private GoogleAuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody GoogleAuthRequestDTO request) {
        try {
            boolean response = authService.authenticate(request);
            return ResponseEntity.ok(response); // Devuelve true si la autenticación es exitosa
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(false); // Devuelve false en caso de error con el estado 401
        }
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        String response = authService.register(user);
        return ResponseEntity.ok(response);
    }
}

