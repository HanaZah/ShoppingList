package com.shoppinglist.backend.services;

import com.shoppinglist.backend.models.DTOs.AuthResponseDTO;
import com.shoppinglist.backend.models.DTOs.LoginUserDTO;

public interface AuthService {

    AuthResponseDTO loginUser(LoginUserDTO loginData);
}
