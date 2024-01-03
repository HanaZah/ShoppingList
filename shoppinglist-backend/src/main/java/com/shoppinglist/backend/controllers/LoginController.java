package com.shoppinglist.backend.controllers;

import com.shoppinglist.backend.models.DTOs.AuthResponseDTO;
import com.shoppinglist.backend.models.DTOs.LoginUserDTO;
import com.shoppinglist.backend.services.AuthService;
import com.shoppinglist.backend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user/login")
public class LoginController {

    private final UserService userService;
    private final AuthService authService;

    public LoginController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Map> noRequestBody() {

        Map<String, String> result = new HashMap<>();
        result.put("error", "Username and password are required.");

        return ResponseEntity.status(401).body(result);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map> badCredentialsError(Exception e) {

        Map<String, String> result = new HashMap<>();

        result.put("message", "Email or password is incorrect.");

        return ResponseEntity.status(401).body(result);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map> otherErrors(Exception e) {

        Map<String, String> result = new HashMap<>();
        result.put("error", e.getMessage());

        return ResponseEntity.status(401).body(result);
    }

    @PostMapping
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid LoginUserDTO loginData) {

        AuthResponseDTO response = authService.loginUser(loginData);


        return ResponseEntity.ok(response);
    }
}
