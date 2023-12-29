package com.shoppinglist.backend.controllers;

import com.shoppinglist.backend.models.DTOs.LoginUserDTO;
import com.shoppinglist.backend.models.User;
import com.shoppinglist.backend.services.UserService;
import com.shoppinglist.backend.utils.FieldErrorsExtractor;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Map> noRequestBody() {

        Map<String, String> result = new HashMap<>();
        result.put("error", "Username and password are required.");

        return ResponseEntity.status(401).body(result);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map> otherErrors(Exception e) {

        Map<String, String> result = new HashMap<>();
        result.put("error", e.getMessage());

        return ResponseEntity.status(401).body(result);
    }

    @PostMapping
    public ResponseEntity<Map> login(@RequestBody @Valid LoginUserDTO loginData) {

        Map<String, String> response = new HashMap<>();
        User loggedUser = userService.loginUser(loginData);

        if(loggedUser == null) {
            response.put("error", "Username or password incorrect");
            return ResponseEntity.status(401).body(response);
        }

        response.put("message", "Logged in");

        return ResponseEntity.ok(response);
    }
}
