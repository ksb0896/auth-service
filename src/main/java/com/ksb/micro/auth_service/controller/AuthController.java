package com.ksb.micro.auth_service.controller;

import com.ksb.micro.auth_service.model.User;
import com.ksb.micro.auth_service.repository.UserRepository;
import com.ksb.micro.auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//DTOs for request/response
record LoginRequest(String username, String password){}
record RegisterRequest(String username, String password){}
record AuthResponse(String token){}

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterRequest request) {
        if (userRepository.findByUsername(request.username()).isPresent()) {
            return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password())); // Hash the password
        userRepository.save(user);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest request) {
        // Find the user by username
        User user = userRepository.findByUsername(request.username())
                .orElse(null);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); // User not found
        }

        // Check if the provided password matches the stored hash
        if (passwordEncoder.matches(request.password(), user.getPassword())) {
            // Passwords match, generate a token
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
