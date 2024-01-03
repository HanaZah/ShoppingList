package com.shoppinglist.backend.services;

import com.shoppinglist.backend.models.User;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.function.Function;

public interface JwtService {

    String extractUsername(String jwt);

    Date extractExpiration(String jwt);

    boolean isTokenValid(String jwt, UserDetails userDetails);

    String generateToken(User user);
}
