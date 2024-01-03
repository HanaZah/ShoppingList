package com.shoppinglist.backend.services;

import com.shoppinglist.backend.models.DTOs.AuthResponseDTO;
import com.shoppinglist.backend.models.DTOs.LoginUserDTO;
import com.shoppinglist.backend.models.DTOs.NewUserDTO;
import com.shoppinglist.backend.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findUserByUsername(String username);

    User createNewUser(NewUserDTO userData);

}
